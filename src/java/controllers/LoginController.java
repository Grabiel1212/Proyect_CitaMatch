package controllers;

import back.entitys.Usuario;
import back.services.PersonaService;
import beans.PersonaBeans;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GRABIEL
 */

@Getter
@Setter
public class LoginController extends ActionSupport {
    
    private String email;   // Las variables deben ser private para usar Lombok
    private String password;
    private PersonaService servicio;
    private Usuario dao;
    private PersonaBeans bean;
    public String codLogin;

    public LoginController() {
        servicio = new PersonaService();
        bean = new PersonaBeans(); 
    }
 @Override
    public String execute() throws Exception {
        return SUCCESS;  // Solo retorna SUCCESS
    }

    public String Validar() {
    try {
        dao = new Usuario(email, password); // Crear el objeto Usuario
        String exito = servicio.LogeoCorreo(dao); // Llamar al servicio de login
        if (exito != null && !exito.isEmpty()) {
            codLogin = exito;
            bean.setIdperfil(exito); // Asignar el perfil al bean
            ActionContext.getContext().getSession().put("codLogin", codLogin); // Guardar en sesión
            System.out.println("ID del perfil en bean: " + bean.getIdperfil());
            return "home"; // Redirigir al home si es exitoso
        } else {
            addActionError("Credenciales inválidas."); // Agregar error si las credenciales no son válidas
            return ERROR;
        }
    } catch (Exception e) {
        System.err.println("Error en Validar: " + e.getMessage()); 
        addActionError("Error durante la validación: " + e.getMessage());
        return ERROR; // Retornar error en caso de excepción
    }

    
    }

}
