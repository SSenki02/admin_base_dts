package Interfaces;

import Implementaciones.Libro;
import java.util.List;

/**
 *
 * @author shans
 */
public interface Libro_int {
    
    public void registrar(Libro lib) throws Exception;
    public void actualizar_estante (Libro lib) throws Exception;
    public List<Libro> listar(String id) throws Exception;
    public Libro busqueda_id(int id_lib) throws Exception;
  
}
