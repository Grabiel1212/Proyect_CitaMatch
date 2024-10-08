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

    public int EmailValidar(Usuario user, String men);

    public boolean ValidarEmailExistente(Usuario user);

    public List<Persona> ListarPorGenero(String cod);

    public Persona InformacionUsuario(String cod);
    
     public void DarMegusta(String codSoli, String codResep);

    public void CanselarMegusta(String codSoli, String codResep);

    public void AseptarMegusta(String codSoli, String codResep);

    public void RechazarMegusta(String codSoli, String codResep);

    public int CantidadMegusta(String cod);

    public List<Persona> obtenerUsuariosQueEnvianMeGusta(String cod);

    public List<Persona> obtenerListamegustaenviados(String cod);

    public List<Persona> obtenerListamegustarechazados(String cod);

}
