
package Implementaciones;

import Interfaces.Prestamo_int;
import com.mycompany.bliblioteca_adminbds.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Impl_Prestamo extends Conexion implements Prestamo_int{
     public void registrar(Prestamo pres) throws Exception{
        try {
            this.establecerConexion();
            PreparedStatement pt = this.establecerConexion().prepareStatement("INSERT INTO DJS_PRESTAMO (FECHA_ACTUAL_PREST, FECHAR_DEV_PREST, ID_USUARIO, FK_ID_LIB) VALUES (?,?,?,?)");
                pt.setString(1, pres.getFecha_prestamo());
                pt.setString(2, pres.getFecha_dev());
                pt.setInt(3, pres.getId_us());
                pt.setInt(4, pres.getId_lib());
                pt.execute();
                JOptionPane.showMessageDialog(null, "Registro agregado");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo agregar el registro");
        }
    }
    
    public void actualizar_fecha (Prestamo prest) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_PRESTAMO SET FECHAR_DEV_PREST=? WHERE ID_PREST=? ");
             pt.setString(1, prest.getFecha_dev());
             pt.setInt(2, prest.getId_prest());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }   
    
   
    
    public List<Prestamo> listar(String id) throws Exception {
        List<Prestamo> lista = null;
        try {
            this.establecerConexion();
            String Query = id.isEmpty() ? "SELECT FECHA_ACTUAL_PREST, FECHAR_DEV_PREST, ID_USUARIO, FK_ID_LIB FROM DJS_PRESTAMO;" : "SELECT FECHA_ACTUAL_PREST, FECHAR_DEV_PREST, ID_USUARIO, FK_ID_LIB FROM DJS_PRESTAMO WHERE ID_PREST LIKE '%" + id + "%';";
            PreparedStatement st = this.establecerConexion().prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Prestamo prest = new Prestamo();
                prest.setFecha_prestamo(rs.getString("FECHA_ACTUAL_PREST"));
                prest.setFecha_dev(rs.getString("FECHAR_DEV_PREST"));
                prest.setId_us(rs.getInt("ID_USUARIO"));
                prest.setId_lib( rs.getInt("FK_ID_LIB"));
                lista.add(prest);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        }
        return lista;
    }
    
     public Prestamo busqueda_id(int id_prest) throws Exception {
         Prestamo prest = null;
        
         try {
             this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("SELECT FECHA_ACTUAL_PREST, FECHAR_DEV_PREST, ID_USUARIO, FK_ID_LIB WHERE ID_PREST=?");
             pt.setInt(1, id_prest);
             
             ResultSet rs=pt.executeQuery();
             while(rs.next()){
                prest = new Prestamo();
                prest.setFecha_prestamo(rs.getString("FECHA_ACTUAL_PREST"));
                prest.setFecha_dev(rs.getString("FECHAR_DEV_PREST"));
                prest.setId_us(rs.getInt("ID_USUARIO"));
                prest.setId_lib(rs.getInt("FK_ID_LIB"));
               
                rs.close();
                pt.close();
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "no se encontro registro");
         }
         
         return prest;
     }  
}
