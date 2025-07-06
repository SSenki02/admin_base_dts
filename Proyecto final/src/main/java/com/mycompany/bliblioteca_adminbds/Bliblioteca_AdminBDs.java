
package com.mycompany.bliblioteca_adminbds;

import IU.Login;


/**
 *
 * @author shans
 */
public class Bliblioteca_AdminBDs {

    public static void main(String[] args) {
        Conexion objetoconexion = new Conexion();
        objetoconexion.establecerConexion();
        
        Login  NP = new Login();
        NP.setVisible(true);
        NP.setLocationRelativeTo(null);
         
    }
}
