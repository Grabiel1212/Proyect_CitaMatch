/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entitys;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 *
 * @author GRABIEL
 */
@Getter // SETTER
@Setter // GETTER
@NoArgsConstructor // CONTRUCTOT VASIO

public class Usuario {
    
    
   private String iduser;
   private String email;
   private String password;
   private String googleId;

    public Usuario(String iduser, String email, String password, String googleId) {
        this.iduser = iduser;
        this.email = email;
        this.password = password;
        this.googleId = googleId;
    }

    
    public Usuario(String email, String password) {
        
        this.email = email;
        this.password = password;
       
    }

    public Usuario(String iduser) {
        this.iduser = iduser;
    }


    @Override
    public String toString() {
        return "Usuario{" + "id=" + iduser + ", email=" + email + ", password=" + password + ", googleId=" + googleId + '}';
    }
   
   

   
    
    
}
