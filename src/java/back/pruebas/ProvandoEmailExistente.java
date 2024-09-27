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
public class ProvandoEmailExistente {
    
    
    public static void main(String[] args) {
        
        PersonaService servicio = new PersonaService();
        
        Usuario user = new Usuario();
        
        user.setEmail("juan1212@gmail.com");
        
       boolean exito = servicio.ValidarEmailExistente(user);
       if (exito){
           System.out.println("coreo verificado");
       }
        
    }
}
