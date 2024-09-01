/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.services;

import back.business.PersonaN;
import back.entitys.Persona;
import back.implents.PersonaImp;
import back.util.Util;
import java.util.List;

/**
 *
 * @author GRABIEL
 */
public class PersonaService implements PersonaServiceImp {

    private PersonaImp personaDao;

    public PersonaService() {

        personaDao = PersonaN.getConnection(Util.MYSQL);

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

}
