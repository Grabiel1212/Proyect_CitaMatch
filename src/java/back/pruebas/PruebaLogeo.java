/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.services.PersonaService;

/**
 *
 * @author juang
 */
public class PruebaLogeo {
    
    public static void main(String[] args) {
         
         Usuario user  = new Usuario("luis.martinez@gmail.com","luis1988");
        Persona per = new Persona();
       
        PersonaService dao = new PersonaService();
       
        String cod = ""; // Inicializamos cod con null
       String  exito = dao.LogeoCorreo(user);
        if (!exito.isEmpty()){
            System.out.println("Logeo exitoso, bienvenido " + exito);
            per.setIduser(user.getIduser());
            dao.ListarPorGenero(exito).forEach(System.out::println);
            
        } else {
            System.out.println("Error de usuario o correo");
        }
       
        
//        // Verificamos si cod no es null antes de compararlo
//        if (cod != null && !cod.isEmpty()) {
//            dao.ListarPorGenero(cod).forEach(System.out::println);
//        } else {
//            System.out.println("Código vacío o null: " + cod);
//        }
    }
    
}
