/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.entitys;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GRABIEL
 */
@Getter
@Setter
public class PersonaC  {
   
   String iduser;
   String email;
   String password;
   String googleId;
   String idperfil;
   String nombre;
   String apellido;
   LocalDate fechaN;
   int edad;
   String genero;
   byte[] fotoPerfil;
   byte[] fotoPortada;
   byte[] foto1;
   byte[] foto2;
   byte[] foto3;
   String ubicacion;
   String intereses;
   String descripcion;


    
}
