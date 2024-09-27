/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.business;

import back.implents.Emailimp;
import back.model.EmailM;
import back.util.Util;

/**
 *
 * @author juang
 */
public class EmailN {
    
      public static Emailimp getEmailValidar(Util util){
        switch(util) {
             case MYSQL : return new EmailM ();
            
            default : return  null;
        }
        
    }
}
