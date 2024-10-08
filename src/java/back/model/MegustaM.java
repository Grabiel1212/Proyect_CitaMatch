/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.model;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.implents.MegustaImpl;
import back.util.ConectarBD;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int CantidadMegusta(String cod) {
        PreparedStatement ps;
        ResultSet rs; // Declaración del ResultSet
        int cantidad = 0;  // Inicializamos la variable cantidad en 0
        String sql = "SELECT COUNT(*) AS TotalLikes FROM megusta WHERE UsuarioReceptorID = ? AND Estado = 'P';";

        try {
            if (con.getConnection() == null) {
                con.connect();
            }

            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, cod);  // Asignamos el valor del parámetro

            rs = ps.executeQuery();  // Cambiamos a executeQuery() para obtener resultados

            if (rs.next()) {
                cantidad = rs.getInt("TotalLikes");  // Obtenemos el valor del campo "TotalLikes"
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();  // Aseguramos que los recursos se cierren correctamente
        }

        return cantidad;  // Retornamos la cantidad de "me gusta"
    }

    @Override
    public List<Persona> obtenerUsuariosQueEnvianMeGusta(String cod) {
        List<Persona> personas = new ArrayList<>();
         String sql = "SELECT megusta.UsuarioSolicitanteID, perfiles.nombre, perfiles.apellido, perfiles.FotoPerfil "
            + "FROM megusta "
            + "INNER JOIN usuarios ON megusta.UsuarioSolicitanteID = usuarios.UsuarioID "
            + "INNER JOIN perfiles ON perfiles.usuarioId = usuarios.UsuarioID "
            + "WHERE megusta.UsuarioReceptorID = ? AND megusta.Estado = 'P'";


        try {
            if (con.getConnection() == null) {
                con.connect();
            }

            // Usamos try-with-resources para asegurar el cierre de los recursos
            try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
                ps.setString(1, cod);  // Asignamos el valor del parámetro
                try (ResultSet rs = ps.executeQuery()) {  // Ejecutamos la consulta
                    while (rs.next()) {
                        String usuarioSolicitanteID = rs.getString("UsuarioSolicitanteID");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        byte[] fotoPerfil = rs.getBytes("FotoPerfil");

                        Persona perfil = new Persona(usuarioSolicitanteID, nombre, apellido , fotoPerfil);
                        personas.add(perfil);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;  // Retornamos la lista de personas
    }

    @Override
      public List<Persona> obtenerListamegustaenviados(String cod) {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT mg.UsuarioReceptorID, p.Nombre, p.Apellido, p.FotoPerfil "
                + "FROM MeGusta mg "
                + "INNER JOIN Usuarios u ON mg.UsuarioReceptorID = u.UsuarioID "
                + "INNER JOIN Perfiles p ON p.UsuarioID = u.UsuarioID "
                + "WHERE mg.UsuarioSolicitanteID = ? AND mg.Estado = 'P'";  // P: Pendiente

        try {
            if (con.getConnection() == null) {
                con.connect();
            }

            try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
                ps.setString(1, cod);  // Asignamos el valor del parámetro
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String usuarioReceptorID = rs.getString("UsuarioReceptorID");
                        String nombre = rs.getString("Nombre");
                        String apellido = rs.getString("Apellido");
                        byte[] fotoPerfil = rs.getBytes("FotoPerfil");

                        Persona perfil = new Persona(usuarioReceptorID, nombre, apellido, fotoPerfil);
                        personas.add(perfil);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;  // Retornamos la lista de personas
    }

    @Override
    public List<Persona> obtenerListamegustarechazados(String cod) {
    List<Persona> personas = new ArrayList<>();
    String sql = "SELECT mg.UsuarioSolicitanteID, p.Nombre, p.Apellido, p.FotoPerfil "
            + "FROM MeGusta mg "
            + "INNER JOIN Usuarios u ON mg.UsuarioSolicitanteID = u.UsuarioID "
            + "INNER JOIN Perfiles p ON p.UsuarioID = u.UsuarioID "
            + "WHERE mg.UsuarioReceptorID = ? AND mg.Estado = 'R'";  // R: Rechazado

    try {
        if (con.getConnection() == null) {
            con.connect();
        }

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
            ps.setString(1, cod);  // Asignamos el valor del parámetro (UsuarioReceptorID)
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String usuarioSolicitanteID = rs.getString("UsuarioSolicitanteID");
                    String nombre = rs.getString("Nombre");
                    String apellido = rs.getString("Apellido");
                    byte[] fotoPerfil = rs.getBytes("FotoPerfil");

                    // Crear objeto Persona con los datos recuperados
                    Persona perfil = new Persona(usuarioSolicitanteID, nombre, apellido, fotoPerfil);
                    personas.add(perfil);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return personas;  // Retornamos la lista de personas
}


}
