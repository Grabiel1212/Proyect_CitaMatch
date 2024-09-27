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
public class ProvandoEmail {
    
    public static void main(String[] args) {
        
        
        
        PersonaService servicio = new PersonaService();
        Usuario user = new Usuario ();
        
        user.setEmail("juangrabielbarbozarivera12@gmail.com");
        
    int cod =servicio.EmailValidar(user ,"recuperar");
    
        System.out.println("el codigo de envio es  : "+  cod);
    }
    
}
