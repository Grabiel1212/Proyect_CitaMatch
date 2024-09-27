/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.services;

import back.business.EmailN;
import back.business.PersonaN;
import back.entitys.Persona;
import back.entitys.Usuario;
import back.implents.Emailimp;
import back.implents.PersonaImp;
import back.util.Util;
import java.util.List;

/**
 *
 * @author GRABIEL
 */
public class PersonaService implements PersonaServiceImp {

    private PersonaImp personaDao;
    private Emailimp emailDao;

    public PersonaService() {

        personaDao = PersonaN.getConnection(Util.MYSQL);
        emailDao = EmailN.getEmailValidar(Util.MYSQL);

    }

    @Override
    public void grabar(Persona p) {
       personaDao.create(p);
    }

    @Override
    public void actualizar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean LogeoCorreo(Usuario user) {
   
        // Llamar al método adecuado en la capa DAO para verificar el logeo
        boolean esLogeoExitoso = personaDao.LogeoEmail(user);

        // Retornar el resultado del DAO
        return esLogeoExitoso;
       
    }

    @Override
    public int EmailValidar(Usuario user , String men) {
        
        
      int cod =   emailDao.EmailValidar(user , men);
         return cod;
    }

    @Override
    public boolean ValidarEmailExistente(Usuario user) {
       
        boolean exito  = personaDao.ValidarEmailExistente(user);
        
        return exito;
    }

}
