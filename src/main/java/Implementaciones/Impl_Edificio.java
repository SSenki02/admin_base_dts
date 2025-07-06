
package Implementaciones;

import Interfaces.Edificio_int;
import com.mycompany.bliblioteca_adminbds.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Impl_Edificio extends Conexion implements Edificio_int {

    public Impl_Edificio() {
    }

      
    public void registrar(Edificio edif) throws Exception{
        try {
            this.establecerConexion();
            PreparedStatement pt = this.establecerConexion().prepareStatement("INSERT INTO DJS_EDIFICIO (NOM_EDIF,DIRECCION_EDIF,TELEFONO_EDIF,CORREO_EDIF) VALUES (?,?,?,?)");
                pt.setString(1, edif.getNombre());
                pt.setString(2, edif.getDireccion());
                pt.setString(3, edif.getTelefono());
                pt.setString(4, edif.getEmail());
                pt.execute();
                JOptionPane.showMessageDialog(null, "Registro agregado");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo agregar el registro");
        }
    }
    
    public void actualizar_telefono (Edificio edif) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_EDIFICIO SET TELEFONO_EDIF=? WHERE ID_EDIF=? ");
             pt.setString(1, edif.getTelefono());
             pt.setInt(2, edif.getId_edif());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }     
 
    public void email_actualizar (Edificio edif) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_EDIFICIO SET CORREO_EDIF=? WHERE ID_EDIF=? ");
             pt.setString(1, edif.getEmail());
             pt.setInt(2, edif.getId_edif());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }     
   
    }
    
    public List<Edificio> listar(String id) throws Exception {
        List<Edificio> lista = null;
        try {
            this.establecerConexion();
            String Query = id.isEmpty() ? "Select NOM_EDIF, DIRECCION_EDIF, TELEFONO_EDIF, CORREO_EDIF FROM DJS_EDIFICIO;" : "Select NOM_EDIF, DIRECCION_EDIF, TELEFONO_EDIF, CORREO_EDIF FROM DJS_EDIFICIO WHERE ID_EDIF LIKE '%" + id + "%';";
            PreparedStatement st = this.establecerConexion().prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Edificio edif = new Edificio();
                edif.setNombre(rs.getString("NOM_EDIF"));
                edif.setDireccion(rs.getString("DIRECCION_EDIF"));
                edif.setTelefono(rs.getString("TELEFONO_EDIF"));
                edif.setEmail(rs.getString("CORREO_EDIF"));
                lista.add(edif);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<Edificio> listar_up(String id) throws Exception {
        List<Edificio> lista = null;
        try {
            this.establecerConexion();
            String Query = id.isEmpty() ? "Select NOM_EDIF, TELEFONO_EDIF, CORREO_EDIF FROM DJS_EDIFICIO;" : "Select NOM_EDIF, TELEFONO_EDIF, CORREO_EDIF FROM DJS_EDIFICIO WHERE ID_EDIF LIKE '%" + id + "%';";
            PreparedStatement st = this.establecerConexion().prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Edificio edif = new Edificio();
                edif.setNombre(rs.getString("NOM_EDIF"));
                edif.setTelefono(rs.getString("TELEFONO_EDIF"));
                edif.setEmail(rs.getString("CORREO_EDIF"));
                lista.add(edif);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        }
        return lista;
    }
    
     public Edificio busqueda_id(int id_edif) throws Exception {
        Edificio edif = null;
        
         try {
             this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("Select NOM_EDIF, TELEFONO_EDIF, CORREO_EDIF FROM DJS_EDIFICIO WHERE ID_EDIF=?");
             pt.setInt(1, id_edif);
             
             ResultSet rs=pt.executeQuery();
             while(rs.next()){
                edif = new Edificio();
                edif.setNombre(rs.getString("NOM_EDIF"));
                edif.setTelefono(rs.getString("TELEFONO_EDIF"));
                edif.setEmail(rs.getString("CORREO_EDIF"));
                
                rs.close();
                pt.close();
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "no se encontro registro");
         }
         
         return edif;
     }  

    @Override
    public void actualizar_email(Edificio edif) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
            
    
}
