/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.model;

import back.entitys.Usuario;
import back.implents.MegustaImpl;
import back.util.ConectarBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juang
 */
public class MegustaM implements MegustaImpl {

   
    private ConectarBD con;
    private PreparedStatement ps;
    private Usuario user;

    public MegustaM() {
        con = new ConectarBD();
        user = new Usuario(); // Inicializar el usuario aquí
    }

    @Override
    public void DarMegusta(String codSoli, String codResep) {
        String sql = "INSERT INTO MeGusta (UsuarioSolicitanteID, UsuarioReceptorID, Estado) VALUES (?, ?, 'P')";
        try {
            if (con.getConnection() == null) {
                con.connect();
            }
            ps = con.getConnection().prepareStatement(sql);

            ps.setString(1, codSoli); 
            ps.setString(2, codResep);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void CanselarMegusta(String codSoli, String codResep) {
        String sql = "DELETE FROM MeGusta WHERE UsuarioSolicitanteID = ? AND UsuarioReceptorID = ? AND Estado = 'P'";
        try {
            if (con.getConnection() == null) {
                con.connect();
            }
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, codSoli); 
            ps.setString(2, codResep); 
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void AseptarMegusta(String codSoli, String codResep) {
        String sql = "UPDATE MeGusta SET Estado = 'A', FechaRespuesta = CURRENT_TIMESTAMP WHERE UsuarioSolicitanteID = ? AND UsuarioReceptorID = ? AND Estado = 'P' OR Estado ='R'";
        try {
            if (con.getConnection() == null) {
                con.connect();
            }
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, codSoli); // ID del usuario solicitante
            ps.setString(2, codResep); // ID del usuario receptor
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void RechazarMegusta(String codSoli, String codResep) {
        String sql = "UPDATE MeGusta SET Estado = 'R', FechaRespuesta = CURRENT_TIMESTAMP WHERE UsuarioSolicitanteID = ? AND UsuarioReceptorID = ? AND Estado = 'P'";
        try {
            if (con.getConnection() == null) {
                con.connect();
            }
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, codSoli); 
            ps.setString(2, codResep); 
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con.getConnection() != null) {
                con.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
