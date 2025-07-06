
package Implementaciones;

public class Usuario {
    
    private int id_us;
    private String Nombre_us;
    private String fecha_nac;
    private String correo_us;
    private String telefono;
     private String edificio;

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
   

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public String getNombre_us() {
        return Nombre_us;
    }

    public void setNombre_us(String Nombre_us) {
        this.Nombre_us = Nombre_us;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo_us() {
        return correo_us;
    }

    public void setCorreo_us(String correo_us) {
        this.correo_us = correo_us;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
