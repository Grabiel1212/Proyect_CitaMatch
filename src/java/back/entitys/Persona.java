/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entitys;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 *
 * @author GRABIEL
 */
@Getter
@Setter
@NoArgsConstructor
public class Persona  extends Usuario{
    
   private String idperfil;
   private String nombre;
   private String apellido;
   private LocalDate fechaN;
   private int edad;
   private String genero;
   private byte[] fotoPerfil;
   private byte[] fotoPortada;
   private byte[] foto1;
   private byte[] foto2;
   private byte[] foto3;
   private String ubicacion;
   private  String intereses;
   private String descripcion;
       private String fotoPerfilBase64; // Este es el nuevo campo para la imagen en Base64

    public Persona(String iduser, String email, String password, String googleId ,String idperfil, String nombre, String apellido, LocalDate fechaN, int edad, String genero, byte[] fotoPerfil, byte[] fotoPortada, byte[] foto1, byte[] foto2, byte[] foto3, String ubicacion, String intereses, String descripcion) {
        super(iduser, email, password, googleId);
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.edad = edad;
        this.genero = genero;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.ubicacion = ubicacion;
        this.intereses = intereses;
        this.descripcion = descripcion;
    }

    public Persona( String iduser ,String idperfil, String nombre, String apellido, LocalDate fechaN, int edad, String genero, byte[] fotoPerfil, byte[] fotoPortada, byte[] foto1, byte[] foto2, byte[] foto3, String ubicacion, String intereses, String descripcion) {
        super(iduser);
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.edad = edad;
        this.genero = genero;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.ubicacion = ubicacion;
        this.intereses = intereses;
        this.descripcion = descripcion;
    }

    public Persona( String iduser ,String nombre, String apellido, byte[] fotoPerfil) {
        super(iduser);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
    }

  
    @Override
 
public String toString() {
    return "Persona{" +
           super.toString() + // Llamada a super.toString() para incluir detalles del Usuario
           ", idperfil=" + idperfil +
           ", nombre=" + nombre +
           ", apellido=" + apellido +
           ", fechaN=" + fechaN +
           ", edad=" + edad +
           ", genero=" + genero +
           ", fotoPerfil=" + fotoPerfil +
           ", fotoPortada=" + fotoPortada +
           ", foto1=" + foto1 +
           ", foto2=" + foto2 +
           ", foto3=" + foto3 +
           ", ubicacion=" + ubicacion +
           ", intereses=" + intereses +
           ", descripcion=" + descripcion +
           '}';
}

    
    
   
   
           
    
    
}
