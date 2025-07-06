
package Implementaciones;

import Interfaces.Edificio_int;
import Interfaces.Libro_int;
import com.mycompany.bliblioteca_adminbds.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Impl_Libro extends Conexion implements Libro_int {

    public Impl_Libro() {
    }

      
    public void registrar(Libro lib) throws Exception{
        try {
            this.establecerConexion();
            PreparedStatement pt = this.establecerConexion().prepareStatement("INSERT INTO DJS_LIBRO (ISBN,TITULO_LIB,AUTOR_LIB,EDITORIAL_LIB, ESTANTE_LIB, ID_EDIF_FK) VALUES (?,?,?,?,?,?)");
                pt.setString(1, lib.getIsbn());
                pt.setString(2, lib.getTitulo_lib());
                pt.setString(3, lib.getAutor_lib());
                pt.setString(4, lib.getEditorial_lib());
                pt.setInt(5, lib.getEstante_lib());
                pt.execute();
                JOptionPane.showMessageDialog(null, "Registro agregado");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo agregar el registro");
        }
    }
    
    public void actualizar_estante (Libro lib) throws Exception{
         try {
            this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("UPDATE DJS_LIBRO SET ESTANTE_LIB=? WHERE ID_LIB=? ");
             pt.setInt(1, lib.getEstante_lib());
             pt.setInt(2, lib.getId_lib());
             pt.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }     
 
   
    public List<Libro> listar(String id) throws Exception {
        List<Libro> lista = null;
        try {
            this.establecerConexion();
            String Query = id.isEmpty() ? "SELECT ISBN, TITULO_LIB, AUTOR_LIB, EDITORIAL_LIB, ESTANTE_LIB, ID_EDIF_FK FROM DJS_LIBRO;" : "SELECT ISBN, TITULO_LIB, AUTOR_LIB, EDITORIAL_LIB, ESTANTE_LIB, ID_EDIF_FK FROM DJS_LIBRO WHERE ID_LIB LIKE '%" + id + "%';";
            PreparedStatement st = this.establecerConexion().prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Libro lib = new Libro();
                lib.setIsbn(rs.getString("ISBN"));
                lib.setTitulo_lib(rs.getString("TITULO_LIB"));
                lib.setAutor_lib(rs.getString("AUTOR_LIB"));
                lib.setEditorial_lib(rs.getString("EDITORIAL_LIB"));
                lib.setEstante_lib(rs.getInt("ESTANTE_LIB"));
                lib.setEdificio(rs.getInt("ID_EDIF_FK"));
                lista.add(lib);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        }
        return lista;
    }
    
     public Libro busqueda_id(int id_lib) throws Exception {
        Libro lib = null;
        
         try {
             this.establecerConexion();
             PreparedStatement pt = this.establecerConexion().prepareStatement("SELECT ISBN, TITULO_LIB, AUTOR_LIB, EDITORIAL_LIB, ESTANTE_LIB,ID_EDIF_FK  FROM DJS_LIBRO WHERE ID_LIB=?");
             pt.setInt(1, id_lib);
             
             ResultSet rs=pt.executeQuery();
             while(rs.next()){
                lib = new Libro();
                lib.setIsbn(rs.getString("ISBN"));
                lib.setTitulo_lib(rs.getString("TITULO_LIB"));
                lib.setAutor_lib(rs.getString("AUTOR_LIB"));
                lib.setEditorial_lib(rs.getString("EDITORIAL_LIB"));
                lib.setEstante_lib(rs.getInt("ESTANTE_LIB"));
                lib.setEdificio(rs.getInt("ID_EDIF_FK"));
                rs.close();
                pt.close();
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "no se encontro registro");
         }
         
         return lib;
     }  

         
    
}
