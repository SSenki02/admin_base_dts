
package Implementaciones;


/**
 *
 * @author shans
 */
public class Edificio {
    
    private int    id_edif;

    public int getId_edif() {
        return id_edif;
    }

    public void setId_edif(int id_edif) {
        this.id_edif = id_edif;
    }
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
}
