/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Persona;
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
public class ContactoControllers extends ActionSupport{
    
    private Persona persona;
    private PersonaC per;

    public ContactoControllers() {
        persona = new Persona();
        per = new PersonaC();
    }

   

    @Override
    public String execute() throws Exception {
        persona.setNombre(per.getNombre());
        persona.setApellido(per.getApellido());
        persona.setEmail(per.getEmail());
        return SUCCESS; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
