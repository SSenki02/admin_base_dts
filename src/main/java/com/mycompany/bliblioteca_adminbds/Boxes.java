
package com.mycompany.bliblioteca_adminbds;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Boxes {
    
    public void Combo_usuario (JComboBox combo_usuario){
        Conexion objetoConexion = new Conexion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        String sql= "	SELECT*FROM DJS_VISUALIZAR_REGISTROS";
        Statement st;
        
        try {
            
            st=objetoConexion.establecerConexion().createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
               modelo.addElement(rs.getString(1));
            }
            rs.close();
        } catch (Exception e) {System.out.println();}
        
    }
    
}
