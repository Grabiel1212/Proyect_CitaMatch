/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Persona;
import back.services.PersonaService;
import beans.PersonaBeans;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Base64;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author juang
 */
@Getter
@Setter
public class PerfilesController extends ActionSupport {

    private PersonaService servicio;
    private Persona persona;
    private PersonaBeans bean;
    List<Persona> perfiles;

    String idPerfil;

    public PerfilesController() {
        servicio = new PersonaService();
        bean = new PersonaBeans();

    }

  public String MostrarPerfilPersona() throws Exception {
    try {
        // Obtener el idPerfil de la solicitud
        idPerfil = ServletActionContext.getRequest().getParameter("idperfil");
        System.out.println("id para listar es: " + idPerfil);

        // Si el idPerfil es nulo o vacío, intentar recuperarlo de la sesión
        if (idPerfil == null || idPerfil.isEmpty()) {
            idPerfil = (String) ActionContext.getContext().getSession().get("idPerfil");
            System.out.println("Recuperado de la sesión id para listar es: " + idPerfil);
        } else {
            // Si idPerfil está disponible, almacenarlo en la sesión para futuras solicitudes
            ActionContext.getContext().getSession().put("idPerfil", idPerfil);
        }

        // Asegurarse de que el idPerfil no sea nulo antes de proceder
        if (idPerfil == null || idPerfil.isEmpty()) {
            throw new Exception("El idPerfil no puede ser nulo.");
        }

        // Buscar la información del usuario basado en el idPerfil
        Persona persona2 = servicio.InformacionUsuario(idPerfil);

        // Verificar si las fotos no son nulas antes de codificarlas
        String fotoPerfil = persona2.getFotoPerfil() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFotoPerfil()) 
                : null;
        String fotoPortada = persona2.getFotoPortada() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFotoPortada()) 
                : null;
        String foto1 = persona2.getFoto1() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto1()) 
                : null;
        String foto2 = persona2.getFoto2() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto2()) 
                : null;
        String foto3 = persona2.getFoto3() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto3()) 
                : null;

        // Establecer los datos en el bean
        bean.setNombre(persona2.getNombre());
        bean.setApellido(persona2.getApellido());
        bean.setEdad(persona2.getEdad());
        bean.setFotoPerfil(fotoPerfil);
        bean.setFotoPortada(fotoPortada);
        bean.setFoto1(foto1);
        bean.setFoto2(foto2);
        bean.setFoto3(foto3);
        bean.setUbicacion(persona2.getUbicacion());
        bean.setIntereses(persona2.getIntereses());
        bean.setDescripcion(persona2.getDescripcion());
        
        System.out.println("Perfil a mostrar : " +  persona2);

        return SUCCESS;

    } catch (Exception e) {
        e.printStackTrace();
        return ERROR;
    }
}

  
    public String MostrarPerfilLogeado() throws Exception {
    try {
        String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
        // Buscar la información del usuario basado en el idPerfil
        Persona persona2 = servicio.InformacionUsuario(codLogin);

        // Verificar si las fotos no son nulas antes de codificarlas
        String fotoPerfil = persona2.getFotoPerfil() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFotoPerfil()) 
                : null;
        String fotoPortada = persona2.getFotoPortada() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFotoPortada()) 
                : null;
        String foto1 = persona2.getFoto1() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto1()) 
                : null;
        String foto2 = persona2.getFoto2() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto2()) 
                : null;
        String foto3 = persona2.getFoto3() != null 
                ? Base64.getEncoder().encodeToString(persona2.getFoto3()) 
                : null;

        // Establecer los datos en el bean
        bean.setNombre(persona2.getNombre());
        bean.setApellido(persona2.getApellido());
        bean.setEdad(persona2.getEdad());
        bean.setFotoPerfil(fotoPerfil);
        bean.setFotoPortada(fotoPortada);
        bean.setFoto1(foto1);
        bean.setFoto2(foto2);
        bean.setFoto3(foto3);
        bean.setUbicacion(persona2.getUbicacion());
        bean.setIntereses(persona2.getIntereses());
        bean.setDescripcion(persona2.getDescripcion());
        
        System.out.println("Perfil a mostrar : " +  persona2);

        return SUCCESS;

    } catch (Exception e) {
        e.printStackTrace();
        return ERROR;
    }
}


}
