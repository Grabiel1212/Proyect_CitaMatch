/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.services.PersonaService;
import beans.PersonaBeans;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author juang
 */
@Getter
@Setter
public class RegistrationController extends ActionSupport {

    private PersonaBeans bean;
    private PersonaService servicio;
    private Persona dao;

    public RegistrationController() {
        bean = new PersonaBeans();
        servicio = new PersonaService();

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

}
