/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;

import back.services.PersonaService;

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
      dao.AseptarMegusta("US001", "US004");
        
        /*
        Prueva de Rechazar Megusta
        */
        
      //  dao.RechazarMegusta("US001", "US004");
        
    }
    
}
