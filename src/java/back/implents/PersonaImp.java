/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.implents;

import back.entitys.Persona;
import back.entitys.Usuario;
import java.util.List;

/**
 *
 * @author GRABIEL
 */
public interface PersonaImp extends GenericDao<Persona,String>{
    
    public String LogeoEmail(Usuario user);
    public boolean ValidarEmailExistente(Usuario user);
     public List<Persona> ListarPorGenero(String cod);
    
}
