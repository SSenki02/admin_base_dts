
package Implementaciones;

import Interfaces.Usuario_int;
import com.mycompany.bliblioteca_adminbds.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Impl_Usuario extends Conexion implements Usuario_int {
    
    public void registrar(Usuario uss) throws Exception{
        try {
            this.establecerConexion();
            PreparedStatement pt = this.establecerConexion().prepareStatement("INSERT INTO DJS_USUARIO (NOMBRE_US, FECHA_NAC_US, COREO_US, TELEFONO_US, FK_ID_EDIF) VALUES (?,?,?,?,?)");
                pt.setString(1, uss.getNombre_us());
                pt.setString(2, uss.getFecha_nac());
                pt.setString(3, uss.getCorreo_us());
                pt.setString(4, uss.getTelefono());
                pt.setString(5, uss.getEdificio());
                pt.execute();
                JOptionPane.showMessageDialog(null, "Registro agregado");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo agregar el registro");
        }
    }
    
    public void actualizar_telefono (Usuario uss) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_USUARIO SET TELEFONO_US=? WHERE ID_US=? ");
             pt.setString(1, uss.getTelefono());
             pt.setInt(2, uss.getId_us());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }   
    
     public void actualizar_correo (Usuario uss) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_USUARIO SET CORREO_US=? WHERE ID_US=? ");
             pt.setString(1, uss.getCorreo_us());
             pt.setInt(2, uss.getId_us());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }   
 
   
    @Override
    public List<Usuario> listar(String id) throws Exception {
        List<Usuario> lista = null;
        try {
            this.establecerConexion();
            String Query = id.isEmpty() ? "SELECT NOMBRE_US, FECHA_NAC_US, CORREO_US, TELEFONO_US, FK_ID_EDIF FROM DJS_USUARIO;" : "SELECT NOMBRE_US, FECHA_NAC_US, CORREO_US, TELEFONO_US, FK_ID_EDIF FROM DJS_USUARIO WHERE ID_US LIKE '%" + id + "%';";
            PreparedStatement st = this.establecerConexion().prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Usuario uss = new Usuario();
                uss.setNombre_us(rs.getString("NOMBRE_US"));
                uss.setFecha_nac(rs.getString("FECHA_NAC_US"));
                uss.setCorreo_us(rs.getString("CORREO_US"));
                uss.setTelefono(rs.getString("TELEFONO_US"));
                uss.setEdificio(rs.getString("FK_ID_EDIF"));
                lista.add(uss);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        }
        return lista;
    }
    
     public Usuario busqueda_id(int id_uss) throws Exception {
        Usuario us = null;
        
         try {
             this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("SELECT NOMBRE_US, FECHA_NAC_US, CORREO_US, TELEFONO_US, FK_ID_EDIF FROM DJS_USUARIO WHERE ID_US=?");
             pt.setInt(1, id_uss);
             
             ResultSet rs=pt.executeQuery();
             while(rs.next()){
                us = new Usuario();
                us.setNombre_us(rs.getString("NOMBRE_US"));
                us.setFecha_nac(rs.getString("FECHA_NAC_US"));
                us.setCorreo_us(rs.getString("CORREO_US"));
                us.setTelefono(rs.getString("TELEFONO_US"));
                 us.setEdificio(rs.getString("FK_ID_EDIF"));
                
                
                rs.close();
                pt.close();
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "no se encontro registro");
         }
         
         return us;
     }  
 
}
