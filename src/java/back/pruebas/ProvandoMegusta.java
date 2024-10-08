/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.services.PersonaService;
import java.util.List;

/**
 *
 * @author juang
 */
public class ProvandoMegusta {
    
    public static void main(String[] args) {
        PersonaService  dao = new  PersonaService();
         
        /*
        
        PRUEVA DE DAR ME GUSTA
        */
        
      // dao.DarMegusta("US001", "US004");
        
        /*
        Prueva de canselar me GUSTA 
        */
        
    //   dao.CanselarMegusta("US001", "US004");
        
        
        /*
        Prueva de Aseptar Megusta
        */
   //   dao.AseptarMegusta("US001", "US004");
        
        /*
        Prueva de Rechazar Megusta
        */
        
      //  dao.RechazarMegusta("US001", "US004");
      
//     int cantidad = dao.CantidadMegusta("US031");
//        System.out.println(cantidad);

//   List<Persona>per;
//          per =   dao.obtenerUsuariosQueEnvianMeGusta("US031");
//       
//          for(Persona persona : per){
//        
//              System.out.println(persona.getIduser());
//           }
//     

  //  dao.obtenerListamegustaenviados("US001").forEach(System.out::println);
  
   dao.obtenerListamegustarechazados("US031").forEach(System.out::println);
       
        
     

        
    }
    
}
