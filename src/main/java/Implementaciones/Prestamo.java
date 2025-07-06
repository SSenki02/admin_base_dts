
package Implementaciones;

public class Prestamo {
    private int id_prest;
    private String fecha_prestamo;
    private String fecha_dev;
    private int id_us;
    private int id_lib;

    public int getId_lib() {
        return id_lib;
    }

    public void setId_lib(int id_lib) {
        this.id_lib = id_lib;
    }
    

    public int getId_prest() {
        return id_prest;
    }

    public void setId_prest(int id_prest) {
        this.id_prest = id_prest;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_dev() {
        return fecha_dev;
    }

    public void setFecha_dev(String fecha_dev) {
        this.fecha_dev = fecha_dev;
    }

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }
}
