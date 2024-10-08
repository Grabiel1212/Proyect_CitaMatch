package controllers;

import back.entitys.Persona;
import back.services.PersonaService;
import beans.PersonaBeans;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Base64;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;


@Getter
@Setter

public class HomeController extends ActionSupport {

    private PersonaService servicio;
    private Persona persona;
    private PersonaBeans bean;
    List<Persona> perfiles;
     private String idUsuarioSelecionado; // O el tipo de dato que corresponda
    
    String idPerfil;

    public HomeController() {
        servicio = new PersonaService();
        bean = new PersonaBeans();

    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;

    }

    public String ListarPerfiles() throws Exception {
        try {
            String codLogin = (String) ActionContext.getContext().getSession().get("codLogin");
            System.out.println("Código verificado en home: " + codLogin);

            int cantidad = CantidadNotificaciones(codLogin);
            bean.setCantidadMegusta(cantidad);
            System.out.println("cantidad de notificaciones : " + bean.getCantidadMegusta());

            // Aquí pones el bean en la sesión para que sea accesible desde el JSP
            ActionContext.getContext().getSession().put("bean", bean);

            if (codLogin != null) {
                perfiles = servicio.ListarPorGenero(codLogin);
                System.out.println("Tamaño de la lista de perfiles: " + perfiles.size());

                if (perfiles != null && !perfiles.isEmpty()) {
                    ActionContext.getContext().getSession().put("perfiles", perfiles);
                }
                return SUCCESS;
            } else {
                //   addActionError("Debes iniciar sesión para acceder al home.");
                return ERROR;  // Redirige al login si no está logueado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String DarLike() throws Exception {
        try {
            // Obtén el ID del usuario logueado desde la sesión
            String codUsuarioLogeado = (String) ActionContext.getContext().getSession().get("codLogin");
            idPerfil = ServletActionContext.getRequest().getParameter("idperfil");

            // Verificar si el ID del perfil y el usuario logueado están presentes
            System.out.println("Usuario que dio like: " + codUsuarioLogeado);
            System.out.println("Perfil que recibió el like: " + idPerfil);

            if (codUsuarioLogeado != null && idPerfil != null) {
                // Aquí puedes llamar a tu servicio para registrar el 'like'

             servicio.DarMegusta(codUsuarioLogeado, idPerfil);
                return SUCCESS;
            } else {
                addActionError("No se pudo registrar el like. Usuario o perfil inválidos.");
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public int CantidadNotificaciones(String cod) {
        int cantidad = 0;
        try {

            cantidad = servicio.CantidadMegusta(cod);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return cantidad;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }
    



}

