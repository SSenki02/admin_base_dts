
package Interfaces;

import Implementaciones.Prestamo;
import java.util.List;


public interface Prestamo_int {
    
    public void registrar(Prestamo pres) throws Exception;
    public void actualizar_fecha (Prestamo prest) throws Exception;
    public List<Prestamo> listar(String id) throws Exception;
    public Prestamo busqueda_id(int id_prest) throws Exception;
}
