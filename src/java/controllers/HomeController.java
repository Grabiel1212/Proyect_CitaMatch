/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Persona;
import back.services.PersonaService;
import com.opensymphony.xwork2.ActionSupport;
import controllers.entitys.PersonaC;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GRABIEL
 */
@Getter
@Setter
public class HomeController  extends ActionSupport{

//    private PersonaService personaS;
//    private Persona personaE;
//    private PersonaC personaC;
    
    
//        public HomeController() {
//
//        personaS  = new PersonaService();
//        personaE = new Persona();
//        personaC = new PersonaC();
//        }
//
       
    
    @Override
    public String execute() throws Exception {
//        try{
//        personaE.setEmail(personaC.getEmail());
//        personaE.setPassword(personaC.getPassword());
//        personaE.setGoogleId(personaC.getGenero()); // O "" si es una cadena vacía
//        personaE.setNombre(personaC.getNombre());
//        personaE.setApellido(personaC.getApellido());
//        personaE.setFechaN(personaC.getFechaN());
//        personaE.setGenero(personaC.getGenero());
//        personaE.setFotoPerfil(personaC.getFotoPerfil());
//        personaE.setFotoPortada(personaC.getFotoPortada());
//        personaE.setUbicacion(personaC.getUbicacion());
//        personaE.setIntereses(personaC.getIntereses());
//        personaE.setDescripcion(personaC.getDescripcion());
//        
//        personaS.grabar(personaE);
//        return SUCCESS; 
//            
//        }catch(Exception e){
//            e.getStackTrace();
//            System.out.println("Error al Agregar Capa Controllers");
//            return ERROR;
//            
//        }
return SUCCESS;
        
    }

      
    
}
