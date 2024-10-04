/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.entitys.Persona;
import back.services.PersonaService;

/**
 *
 * @author juang
 */
public class provarInformacionPerosnal {
    
    public static void main(String[] args) {
        
        PersonaService servicio = new PersonaService();
        
        // Cambié 'US001' a "US001" para que sea una cadena
        Persona persona = servicio.InformacionUsuario("US001");
        
        // Opcional: Imprimir la información de la persona
        if (persona != null) {
            System.out.println("Información de usuario: " + persona.toString()); // Asegúrate de tener un método toString() en la clase Persona
        } else {
            System.out.println("No se encontró la información del usuario.");
        }
    }
    
}
