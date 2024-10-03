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
    try {
        String resultadoValidacion = Validar();
        if (resultadoValidacion != null && !resultadoValidacion.isEmpty()) {
            // Guardar el código de usuario en la sesión
            ActionContext.getContext().getSession().put("codLogin", codLogin);
            addActionMessage("¡Bienvenido! Has iniciado sesión correctamente.");
            return "home"; 
        } else {
            addActionError("Credenciales inválidas."); 
            return ERROR; 
        }
    } catch (Exception e) {
        addActionError("Ocurrió un error durante el inicio de sesión: " + e.getMessage()); 
        return ERROR; // Retorna error
    }
}

    public String Validar() {
        String exito = null;
        try {
            dao = new Usuario(email, password);
            exito = servicio.LogeoCorreo(dao); 
            if (exito != null && !exito.isEmpty()) {
                
                codLogin = exito;
                bean.setIdperfil(exito);
                System.out.println("id beanss : " + bean.getIdperfil());
            }
        } catch (Exception e) {
            System.err.println("Error en Validar: " + e.getMessage()); 
        }
        return exito;
    }
}
