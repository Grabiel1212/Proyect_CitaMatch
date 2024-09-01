/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GRABIEL
 */
@Getter 
@Setter
public class LoginController extends ActionSupport{
     private String email;   // Las variables deben ser private para usar Lombok
    private String password;

    @Override
    public String execute() throws Exception {
        // Lógica de autenticación
        boolean isAuthenticated = authenticate(email, password);

        if (isAuthenticated) {
            return SUCCESS;  // Redirige a home.jsp
        } else {
            addActionError("Correo electrónico o contraseña incorrectos");
            return INPUT;    // Redirige de vuelta a login.jsp
        }
    }

    private boolean authenticate(String email, String password) {
        // Aquí deberías implementar la lógica de autenticación real, como verificar contra una base de datos.
        // Este es solo un ejemplo simple:
        return "juan".equalsIgnoreCase(email) && "1212".equals(password);
    }
    
  
}
