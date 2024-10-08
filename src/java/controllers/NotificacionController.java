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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author juang
 */
@Getter
@Setter
public class NotificacionController extends ActionSupport {

    private PersonaService servicio;
    private Persona persona;
    private PersonaBeans bean;
    List<Persona> personas;
    private String idUsuarioAceptado; // O el tipo de dato que corresponda

    public NotificacionController() {
        servicio = new PersonaService();
        bean = new PersonaBeans();
    }

    @Override
    public String execute() throws Exception {
        return super.execute(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public String ListarNotificaciones() throws Exception {
        String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
        personas = new ArrayList<>();

        try {
            // Obtener la lista de personas que dieron "Me Gusta"
            List<Persona> personasRecibidas = servicio.obtenerUsuariosQueEnvianMeGusta(codLogin);

            // Mostrar en consola los datos que se obtienen
            for (Persona p : personasRecibidas) {
                // Convertir el byte[] de fotoPerfil a Base64
                if (p.getFotoPerfil() != null) {
                    String fotoBase64 = Base64.getEncoder().encodeToString(p.getFotoPerfil());
                    p.setFotoPerfilBase64(fotoBase64); // Asegúrate de tener un setter para esto en la clase Persona
                }
                System.out.println("ID : " + p.getIduser() + " foto : " + (p.getFotoPerfil() != null ? "present" : "no hay") + " Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido());
                personas.add(p);  // Agregar a la lista que se enviará a la vista
            }

            // Configurar el ValueStack con la lista de personas
            ActionContext.getContext().put("personas", personas);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String AceptarLike() throws Exception {
        try {

            String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
            // Imprimir en consola el ID del usuario aceptado
            System.out.println("ID del usuario que aceptó el Me Gusta: " + idUsuarioAceptado);
            servicio.AseptarMegusta(idUsuarioAceptado, codLogin);
            // Aquí puedes añadir la lógica para actualizar el estado en la base de datos si es necesario

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    public String AceptarLike2() throws Exception {
        try {

            String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
            // Imprimir en consola el ID del usuario aceptado
            System.out.println("ID del usuario que aceptó el Me Gusta: " + idUsuarioAceptado);
            servicio.AseptarMegusta(idUsuarioAceptado, codLogin);
            // Aquí puedes añadir la lógica para actualizar el estado en la base de datos si es necesario

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String RechazarLike() throws Exception {
        try {

            String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
            // Imprimir en consola el ID del usuario aceptado
            System.out.println("ID del usuario que rehazo me Gusta: " + idUsuarioAceptado);
            // Aquí puedes añadir la lógica para actualizar el estado en la base de datos si es necesario
            servicio.RechazarMegusta(idUsuarioAceptado, codLogin);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    public String CancelarLike() throws Exception {
        try {

            String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
            // Imprimir en consola el ID del usuario aceptado
            System.out.println("ID del usuario que rehazo me Gusta: " + idUsuarioAceptado);
            // Aquí puedes añadir la lógica para actualizar el estado en la base de datos si es necesario
            servicio.CanselarMegusta(codLogin , idUsuarioAceptado );

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String listamegustarechazaos() throws Exception {
       String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
        personas = new ArrayList<>();

        try {
            // Obtener la lista de personas que dieron "Me Gusta"
            List<Persona> personasRecibidas = servicio.obtenerListamegustarechazados(codLogin);

            // Mostrar en consola los datos que se obtienen
            for (Persona p : personasRecibidas) {
                // Convertir el byte[] de fotoPerfil a Base64
                if (p.getFotoPerfil() != null) {
                    String fotoBase64 = Base64.getEncoder().encodeToString(p.getFotoPerfil());
                    p.setFotoPerfilBase64(fotoBase64); // Asegúrate de tener un setter para esto en la clase Persona
                }
                System.out.println("ID : " + p.getIduser() + " foto : " + (p.getFotoPerfil() != null ? "present" : "no hay") + " Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido());
                personas.add(p);  // Agregar a la lista que se enviará a la vista
            }

            // Configurar el ValueStack con la lista de personas
            ActionContext.getContext().put("personas", personas);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String listamegustaenviados() throws Exception {
        String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
        personas = new ArrayList<>();

        try {
            // Obtener la lista de personas que dieron "Me Gusta"
            List<Persona> personasRecibidas = servicio.obtenerListamegustaenviados(codLogin);

            // Mostrar en consola los datos que se obtienen
            for (Persona p : personasRecibidas) {
                // Convertir el byte[] de fotoPerfil a Base64
                if (p.getFotoPerfil() != null) {
                    String fotoBase64 = Base64.getEncoder().encodeToString(p.getFotoPerfil());
                    p.setFotoPerfilBase64(fotoBase64); // Asegúrate de tener un setter para esto en la clase Persona
                }
                System.out.println("ID : " + p.getIduser() + " foto : " + (p.getFotoPerfil() != null ? "present" : "no hay") + " Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido());
                personas.add(p);  // Agregar a la lista que se enviará a la vista
            }

            // Configurar el ValueStack con la lista de personas
            ActionContext.getContext().put("personas", personas);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
