/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.services;

import back.entitys.Persona;
import back.entitys.Usuario;
import java.util.List;

/**
 *
 * @author GRABIEL
 */
public interface PersonaServiceImp {
    public void grabar(Persona p);
    public void actualizar(Persona p);
    public void eliminar(String id);
    public Persona buscar(String id);
    public List<Persona> listar();
    public String LogeoCorreo(Usuario user);
    public int EmailValidar(Usuario user ,String men);
        public boolean ValidarEmailExistente(Usuario user);
        public List<Persona> ListarPorGenero(String cod);
    
}
