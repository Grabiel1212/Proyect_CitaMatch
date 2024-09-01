/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.pruebas;


import back.entitys.Persona;
import back.services.PersonaService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 *
 * @author GRABIEL
 */
public class PruevaAgregadoUsuario {

    public static void main(String[] args) {

      PersonaService persona = new PersonaService();

        Persona p = new Persona();
        // Para fechaN (suponiendo que la fecha está en formato "YYYY-MM-DD")
        String fechaTexto = "1985-05-15"; // Ejemplo de fecha en formato de texto
        LocalDate fecha = LocalDate.parse(fechaTexto); // Convertir a LocalDate

        byte[] fotoPerfil = null;
        byte[] fotoPortada = null;

        try {
            Path rutaImagen = Paths.get("C:\\Users\\GRABIEL\\Pictures\\Nitro\\01.jpg"); // Ruta a la imagen
            fotoPerfil = Files.readAllBytes(rutaImagen); // Leer la imagen y convertirla a byte[]
            fotoPortada = Files.readAllBytes(rutaImagen); // Leer la imagen y convertirla a byte[]
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción de IO (por ejemplo, archivo no encontrado)
        } catch (InvalidPathException e) {
            e.printStackTrace(); // Manejar la excepción de una ruta inválida
        }

        p.setEmail("mariaterres@gmail.com");
        p.setPassword("");
        p.setGoogleId("google112trs"); // O "" si es una cadena vacía
        p.setNombre("maria");
        p.setApellido("Pérez");
        p.setFechaN(fecha);
        p.setGenero("M");
        p.setFotoPerfil(fotoPerfil);
        p.setFotoPortada(fotoPortada);
        p.setUbicacion("Lima");
        p.setIntereses("Deportes, lectura");
        p.setDescripcion("Descripción breve sobre Juan.");

        persona.grabar(p);
    }

}
