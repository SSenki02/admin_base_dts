
package Interfaces;

import Implementaciones.Libro;
import Implementaciones.Usuario;
import java.util.List;

/**
 *
 * @author shans
 */
public interface Usuario_int {
    public void registrar(Usuario uss) throws Exception;
    public void actualizar_telefono (Usuario uss) throws Exception;
    public void actualizar_correo (Usuario uss) throws Exception;
    public List<Usuario> listar(String id) throws Exception;
     public Usuario busqueda_id(int id_uss) throws Exception;
    
}
