/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.entitys.Usuario;
import back.services.PersonaService;

/**
 *
 * @author juang
 */
public class PruebaLogeo {
    
    public static void main(String[] args) {
         
        Usuario user  = new Usuario("juan@gmail.com","1212");
        
       PersonaService  dao = new PersonaService();
       
       boolean exito = dao.LogeoCorreo(user);
       if (exito){
           System.out.println("logeo exitos bienvenido ");
       }else{
           System.out.println("eror de usurio p correo");
       }
    }
    
}
