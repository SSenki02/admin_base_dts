
package com.mycompany.bliblioteca_adminbds;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   Connection conectar=null;
    
    String usuario = "sa";
    String contrasenia="herondale";
    String db = "SDJ_PROYECTO";
    String ip = "SHAN";
    String puerto = "1433";
    
    
    public Connection establecerConexion(){
        
        try {
            String cadena = "jdbc:sqlserver://" + ip + ":" + puerto + ";"
                         + "databaseName=" + db + ";"
                         + "user=" + usuario + ";"
                         + "password=" + contrasenia + ";"
                         + "encrypt=true;"
                         + "trustServerCertificate=true;";
            
            conectar = DriverManager.getConnection(cadena);
           System.out.println("Conexión con la base de datos correcta");
           System.out.println("Conectado a: " + conectar.getCatalog());
        } catch (Exception e) {
           
            System.out.println("Error al conectar la base de datos. Error"+ e.toString());
        }
        return conectar;   
    }
     
}
