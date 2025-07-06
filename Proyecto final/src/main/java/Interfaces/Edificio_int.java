
package Interfaces;

import Implementaciones.Edificio;
import java.util.List;

/**
 *
 * @author shans
 */
public interface Edificio_int {
    public void registrar(Edificio edif) throws Exception;
    public void actualizar_telefono (Edificio edif) throws Exception;
    public void actualizar_email (Edificio edif) throws Exception;
   // public void eliminar(String title) throws Exception;
    public List<Edificio> listar(String id) throws Exception;
    public Edificio busqueda_id(int id_edif) throws Exception;
     public List<Edificio> listar_up(String id) throws Exception;
}
