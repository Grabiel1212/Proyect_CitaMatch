/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.services.PersonaService;
import beans.PersonaBeans;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author juang
 */
@Getter
@Setter
public class RegistrationController extends ActionSupport implements ServletResponseAware {

    private PersonaBeans bean;
    private PersonaService servicio;
    private Persona dao;
    private HttpServletResponse response;
    int codigoR;

    public RegistrationController() {
        bean = new PersonaBeans();
        servicio = new PersonaService();
        this.response = response;

    }

    @Override
    public String execute() throws Exception {
        return SUCCESS; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    // Método que se llama cuando se ejecuta la acción "registrar"
    public String Registrar() {
        try {
            // Validar y convertir fechaN
            LocalDate fecha;
            try {
                fecha = LocalDate.parse(bean.getFechaN()); // Convertir a LocalDate
            } catch (DateTimeParseException e) {
                addFieldError("bean.fechaN", "La fecha debe estar en formato YYYY-MM-DD.");
                return INPUT; // Regresar a la vista de entrada en caso de error
            }

            byte[] fotoPerfil = null;
            byte[] fotoPortada = null;

            // Leer imágenes desde el sistema de archivos
            try {
                Path rutaImagen = Paths.get(bean.getFotoPerfil()); // Ruta a la imagen de perfil
                fotoPerfil = Files.readAllBytes(rutaImagen); // Leer la imagen y convertirla a byte[]
            } catch (IOException | InvalidPathException e) {
                addFieldError("bean.fotoPerfil", "Error al cargar la imagen de perfil: " + e.getMessage());
                return INPUT; // Regresar a la vista de entrada en caso de error
            }

            try {
                Path rutaImagen2 = Paths.get(bean.getFotoPortada()); // Ruta a la imagen de portada
                fotoPortada = Files.readAllBytes(rutaImagen2); // Leer la imagen y convertirla a byte[]
            } catch (IOException | InvalidPathException e) {
                addFieldError("bean.fotoPortada", "Error al cargar la imagen de portada: " + e.getMessage());
                return INPUT; // Regresar a la vista de entrada en caso de error
            }

            // Crear una nueva instancia de Persona y asignar los valores del bean
            dao = new Persona();
            dao.setEmail(bean.getEmail());
            dao.setPassword(bean.getPassword());
            dao.setGoogleId(bean.getGoogleId() != null ? bean.getGoogleId() : ""); // Manejar GoogleId
            dao.setNombre(bean.getNombre());
            dao.setApellido(bean.getApellido());
            dao.setFechaN(fecha);
            dao.setGenero(bean.getGenero());
            dao.setFotoPerfil(fotoPerfil);
            dao.setFotoPortada(fotoPortada);
            dao.setUbicacion(bean.getUbicacion());
            dao.setIntereses(bean.getIntereses());
            dao.setDescripcion(bean.getDescripcion());

            // Llamar al servicio para registrar a la persona
            servicio.grabar(dao);
            return SUCCESS; // Redirigir a página de éxito
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error al registrar. Por favor, inténtalo de nuevo."); // Mensaje de error general
            return ERROR; // Redirigir a página de error en caso de fallo
        }
    }

    // Método para validar el correo electrónico mediante AJAX
    public void ValidarCorreo() {
        dao = new Persona();
        try {
            dao.setEmail(bean.getEmail());

            boolean existente = servicio.ValidarEmailExistente(dao);

            // Enviar la respuesta correcta en función de si el correo está registrado
            if (!existente) {
                int codigoResivido = servicio.EmailValidar(dao, "registro");
                System.out.println("el codigo es : " + codigoResivido);
                codigoR = codigoResivido;

                response.getWriter().write("validado");

                // Guardar el código en la sesión
                Map<String, Object> session = ActionContext.getContext().getSession();
                session.put("codigo_verificacion", codigoResivido);
            } else {
                response.getWriter().write("input");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write("denegado");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

   // Método para validar el código de verificación mediante AJAX
public void ValidarCodigoVerificacion() {
    try {
        // Recuperar el código de verificación de la sesión
        Map<String, Object> session = ActionContext.getContext().getSession();
        Integer codigoVerificacion = (Integer) session.get("codigo_verificacion");

        // Obtener el código ingresado desde el bean
        int codigoIngresado = bean.getCodigoVeri();

        // Verificar que ambos códigos sean mayores a 0
        if (codigoVerificacion != null && codigoVerificacion > 0 && codigoIngresado > 0) {
            
            if (codigoVerificacion.equals(codigoIngresado)) {
                System.out.println("El código es: " + codigoVerificacion);
                response.getWriter().write("correcto");
            } else {
                response.getWriter().write("codigo_incorrecto");
            }
        } else {
           
            response.getWriter().write("codigo_incorrecto");
        }
    } catch (Exception e) {
        e.printStackTrace();
        try {
            response.getWriter().write("error");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

    

    // Método para establecer la respuesta HTTP (implementación de ServletResponseAware)
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

}
