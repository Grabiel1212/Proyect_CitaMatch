/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.util.ConectarBD;

/**
 *
 * @author GRABIEL
 */
public class PruevaConexion {
    
    public static void main(String[] args) {
        ConectarBD con = new ConectarBD();
        con.connect();
        con.disconnect();
        
    }
    
}
