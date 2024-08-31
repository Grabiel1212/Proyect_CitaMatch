/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.business;

import back.implents.PersonaImp;
import back.model.PersonaM;
import back.util.Util;

/**
 *
 * @author GRABIEL
 */
public class PersonaN {
    
    public static PersonaImp getConnection(Util util){
        switch(util) {
            
            case MYSQL : return new PersonaM ();
            default : return  null;
        }
        
    }
    
}
