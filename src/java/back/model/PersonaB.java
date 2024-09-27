/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.model;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.implents.PersonaImp;
import back.util.ConecctionMybatis;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author juang
 */
public class PersonaB implements PersonaImp {
    
      private SqlSession session ;
//      private Persona perosona;
      
      public PersonaB() {
      session  = new ConecctionMybatis().getSession();
//      persona = new Persona();
      }
      
         public void testConnection() {
        if (session != null) {
            try {
                // Llamar al mapeo SQL definido en mappers.xml
                String result = session.selectOne("testConnection");
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        } else {
            System.out.println("Error al obtener la sesión de MyBatis.");
        }
    }

    @Override
    public void create(Persona persona) {
         if (session !=null){
           try {
            // Ejecuta la consulta "crear" del mapper
           session.insert("registrarUsuario", persona);

            session.commit(); // Confirma la transacción
               System.out.println("Registro exitoso");
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); // Revierte en caso de error
        } finally {
            if (session != null) {
                session.close();
            }
        }
          
      }else{
          System.out.println("error de seccion capa model");
      }
        
        
    }

    @Override
    public Persona find(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Persona t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean LogeoEmail(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ValidarEmailExistente(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

    
}
