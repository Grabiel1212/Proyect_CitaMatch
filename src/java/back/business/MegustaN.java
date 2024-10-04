/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.business;

import back.implents.MegustaImpl;
import back.model.MegustaM;

import back.util.Util;
import static back.util.Util.MYSQL;

/**
 *
 * @author juang
 */
public class MegustaN {
    
    public static MegustaImpl getMegusta (Util util){
        switch(util) {
             case MYSQL : return new MegustaM ();
           
            default : return  null;
        }
        
    }
        
    
}
