package controllers;

import back.entitys.Persona;
import back.services.PersonaService;
import beans.PersonaBeans;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class HomeController extends ActionSupport {

    private PersonaService servicio;
    private Persona persona;
    private PersonaBeans bean;
    List<Persona> perfiles;

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

            if (codLogin != null) {
                perfiles = servicio.ListarPorGenero(codLogin);
                System.out.println("Tamaño de la lista de perfiles: " + perfiles.size());

                if (perfiles != null && !perfiles.isEmpty()) {
                    ActionContext.getContext().getSession().put("perfiles", perfiles);
                }
                return SUCCESS;
            } else {
                addActionError("Debes iniciar sesión para acceder al home.");
                return ERROR;  // Redirige al login si no está logueado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
