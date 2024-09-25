/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Usuario;
import back.services.PersonaService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GRABIEL
 */

public class LoginController extends ActionSupport{
    
    private String email;   // Las variables deben ser private para usar Lombok
    private String password;
    private PersonaService servicio;
    private Usuario dao;
    
    public LoginController(){
         dao = new Usuario();
         servicio = new PersonaService ();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonaService getServicio() {
        return servicio;
    }

    public void setServicio(PersonaService servicio) {
        this.servicio = servicio;
    }

    public Usuario getDao() {
        return dao;
    }

    public void setDao(Usuario dao) {
        this.dao = dao;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    @Override
    public String execute() throws Exception {
       
        try {
            if (Validar()) {
                return "home"; // Redirige a home si el login es exitoso
            } else {
                addActionError("Credenciales inválidas. Inténtalo de nuevo."); // Mensaje de error si el login falla
                return ERROR; // Retorna error si las credenciales son inválidas
            }
        } catch (Exception e) {
            addActionError("Ocurrió un error durante el inicio de sesión: " + e.getMessage()); // Mensaje de error en caso de excepción
            return ERROR; // Retorna error
        }
    }
    
    
   public boolean Validar() {
        boolean v = false;
        
        try {
            dao.setEmail(email);
            dao.setPassword(password);
            v = servicio.LogeoCorreo(dao); // Llama al servicio para validar credenciales
            if (v) {
                System.out.println("Bienvenido capa");
            }
        } catch (Exception e) {
            System.err.println("Error en Validar: " + e.getMessage()); // Log de errores si ocurre un problema en Validar
        }
        
        return v;
    }
    

 
    
  
}
