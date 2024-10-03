/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.entitys.Persona;
import back.services.PersonaService;
import java.util.List;

/**
 *
 * @author juang
 */
public class ProvarListadoPerfiles {
      public static void main(String[] args) {
        
        
       PersonaService servicio = new PersonaService();
      
       String  cod ="US001";
       
//       
////       servicio.ListarPorGenero(per).forEach(System.out::println);
// // Listar perfiles filtrados por género, pero sin nombre y apellido
//        servicio.ListarPorGenero(cod).forEach(perfil -> {
//            // Imprimir solo los datos sin nombre y apellido
//            System.out.println("ID Perfil: " + perfil.getIdperfil());
//            System.out.println("Género: " + perfil.getGenero());
//            // Aquí puedes agregar otros campos si los necesitas, excepto nombre y apellido
//        });
  // Listar perfiles filtrados por género
    List<Persona> perfilesFiltrados = servicio.ListarPorGenero(cod);
    
    // Verificar si hay al menos un perfil en la lista
    if (!perfilesFiltrados.isEmpty()) {
        // Obtener el primer perfil (posición 1)
       Persona primerPerfil = perfilesFiltrados.get(2);
        
        // Imprimir solo los datos sin nombre y apellido
        System.out.println("ID Perfil: " + primerPerfil.getIdperfil());
        System.out.println("Género: " + primerPerfil.getGenero());
        // Agrega otros campos si los necesitas
    } else {
        System.out.println("No se encontraron perfiles para el género especificado.");
    }
       
      
           
      }
    
}
