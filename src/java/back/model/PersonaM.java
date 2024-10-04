package back.model;

import back.entitys.Persona;
import back.entitys.Usuario;
import back.implents.PersonaImp;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import back.util.ConectarBD;
import java.time.LocalDate;

public class PersonaM implements PersonaImp {

    ConectarBD cn = new ConectarBD();

    @Override
    public void create(Persona unaPersona) {
        CallableStatement cs = null;

        try {
            // Asegúrate de que la conexión esté establecida
            if (cn.getConnection() == null) {
                cn.connect(); // Conecta si no está conectado
            }

            // Crear CallableStatement para llamar al procedimiento almacenado
            String sql = "{call RegistrarUsuarioConPerfil(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            cs = cn.getConnection().prepareCall(sql);

            // Establecer los valores de los parámetros
            cs.setString(1, unaPersona.getEmail());
            cs.setString(2, unaPersona.getPassword());

            if (unaPersona.getGoogleId() == null || unaPersona.getGoogleId().isEmpty()) {
                cs.setNull(3, java.sql.Types.VARCHAR);
            } else {
                cs.setString(3, unaPersona.getGoogleId());
            }

            cs.setString(4, unaPersona.getNombre());
            cs.setString(5, unaPersona.getApellido());
            cs.setDate(6, java.sql.Date.valueOf(unaPersona.getFechaN())); // Si fechaN es LocalDate

            cs.setString(7, unaPersona.getGenero());

            if (unaPersona.getFotoPerfil() == null) {
                cs.setNull(8, java.sql.Types.BLOB);
            } else {
                cs.setBytes(8, unaPersona.getFotoPerfil());
            }

            if (unaPersona.getFotoPortada() == null) {
                cs.setNull(9, java.sql.Types.BLOB);
            } else {
                cs.setBytes(9, unaPersona.getFotoPortada());
            }

            cs.setString(10, unaPersona.getUbicacion());
            cs.setString(11, unaPersona.getIntereses());
            cs.setString(12, unaPersona.getDescripcion());

            // Ejecutar el procedimiento almacenado
            cs.execute(); // No necesitamos capturar el número de filas afectadas si no devolvemos un valor
        } catch (SQLException e) {
            System.err.println("Error al crear la persona: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn.getConnection() != null) {
                    cn.disconnect(); // Desconectar
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public Persona findById(String iduser) {
        Persona oPersona = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            // Asegúrate de que la conexión esté establecida
            if (cn.getConnection() == null) {
                cn.connect(); // Conecta si no está conectado
            }

            // Crear CallableStatement para llamar al procedimiento almacenado
            String sql = "{call buscar_usuario(?)}";
            cs = cn.getConnection().prepareCall(sql);

            // Establecer el valor del parámetro
            cs.setString(1, iduser);

            // Ejecutar el procedimiento almacenado
            rs = cs.executeQuery();

            // Procesar el ResultSet
            if (rs.next()) {
                oPersona = new Persona(
                        rs.getString("iduser"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("googleId"),
                        rs.getString("idperfil"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fechaN").toLocalDate(), // Convertir java.sql.Date a LocalDate
                        rs.getInt("edad"),
                        rs.getString("genero"),
                        rs.getBytes("fotoPerfil"),
                        rs.getBytes("fotoPortada"),
                        rs.getBytes("foto1"),
                        rs.getBytes("foto2"),
                        rs.getBytes("foto3"),
                        rs.getString("ubicacion"),
                        rs.getString("intereses"),
                        rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar la persona: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (cn.getConnection() != null) {
                    cn.disconnect(); // Desconectar
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return oPersona;
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> lista = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            cn.connect(); // Establece la conexión
            conn = cn.getConnection(); // Obtén la conexión

            // Crear CallableStatement para ejecutar el procedimiento almacenado
            cs = conn.prepareCall("{call listar_usuario()}");

            // Ejecutar la consulta
            rs = cs.executeQuery();

            // Procesar el ResultSet
            while (rs.next()) {
                lista.add(new Persona(
                        rs.getString("iduser"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("googleId"),
                        rs.getString("idperfil"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getObject("fechaN", LocalDate.class),
                        rs.getInt("edad"),
                        rs.getString("genero"),
                        rs.getBytes("fotoPerfil"),
                        rs.getBytes("fotoPortada"),
                        rs.getBytes("foto1"),
                        rs.getBytes("foto2"),
                        rs.getBytes("foto3"),
                        rs.getString("ubicacion"),
                        rs.getString("intereses"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error al listar personas: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    cn.disconnect(); // Desconectar usando el método de desconexión
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return lista;
    }

    @Override
    public void update(Persona unaPersona) {
        CallableStatement cs = null;

        try {
            // Asegúrate de que la conexión esté establecida
            if (cn.getConnection() == null) {
                cn.connect(); // Conecta si no está conectado
            }

            // Crear CallableStatement para llamar al procedimiento almacenado
            String sql = "{call actualizar_usuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            cs = cn.getConnection().prepareCall(sql);

            // Establecer los valores de los parámetros
            cs.setString(1, unaPersona.getEmail());
            cs.setString(2, unaPersona.getPassword());
            cs.setString(3, unaPersona.getGoogleId());
            cs.setString(4, unaPersona.getIdperfil());
            cs.setString(5, unaPersona.getNombre());
            cs.setString(6, unaPersona.getApellido());
            cs.setDate(7, java.sql.Date.valueOf(unaPersona.getFechaN())); // Si fechaN es LocalDate
            cs.setInt(8, unaPersona.getEdad());
            cs.setString(9, unaPersona.getGenero());
            cs.setBytes(10, unaPersona.getFotoPerfil());
            cs.setBytes(11, unaPersona.getFotoPortada());
            cs.setBytes(12, unaPersona.getFoto1());
            cs.setBytes(13, unaPersona.getFoto2());
            cs.setBytes(14, unaPersona.getFoto3());
            cs.setString(15, unaPersona.getUbicacion());
            cs.setString(16, unaPersona.getIntereses());
            cs.setString(17, unaPersona.getDescripcion());
            cs.setString(18, unaPersona.getIduser()); // ID del usuario para identificar la fila a actualizar

            // Ejecutar el procedimiento almacenado
            cs.executeUpdate(); // No necesitamos capturar el número de filas afectadas si no devolvemos un valor
        } catch (SQLException e) {
            System.err.println("Error al actualizar la persona: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn.getConnection() != null) {
                    cn.disconnect(); // Desconectar
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(String iduser) {
        CallableStatement cs = null;

        try {
            // Asegúrate de que la conexión esté establecida
            if (cn.getConnection() == null) {
                cn.connect(); // Conecta si no está conectado
            }

            // Crear CallableStatement para llamar al procedimiento almacenado
            String sql = "{call eliminar_usuario(?)}";
            cs = cn.getConnection().prepareCall(sql);

            // Establecer el valor del parámetro
            cs.setString(1, iduser);

            // Ejecutar el procedimiento almacenado
            cs.execute(); // Ejecutar el procedimiento almacenado sin esperar resultados
        } catch (SQLException e) {
            System.err.println("Error al eliminar la persona: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn.getConnection() != null) {
                    cn.disconnect(); // Desconectar
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    @Override
    public Persona find(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String LogeoEmail(Usuario user) {

        String exitoso = null;

        CallableStatement cs = null;
        ResultSet rs = null;

        String idUsuario = null;

        try {
            if (cn.getConnection() == null) {
                cn.connect();
            }

            String sql = "{call LoginUsuario(?, ?)}";
            cs = cn.getConnection().prepareCall(sql);

            cs.setString(1, user.getEmail());
            cs.setString(2, user.getPassword());

            rs = cs.executeQuery();

            if (rs.next()) {
                // Logeo exitoso, obtener idUsuario
                idUsuario = rs.getString("UsuarioID");
                System.out.println("Logeo exitoso. ID Usuario: " + idUsuario);
                exitoso = rs.getString("UsuarioID");
            } else {
                System.out.println("Error: Credenciales incorrectas.");
            }

        } catch (Exception e) {
            System.out.println("Error en la capa Modelo");
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet y CallableStatement si no son nulos
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cs != null) {
                try {
                    cs.close();
                    cn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return exitoso;
    }

    @Override
    public boolean ValidarEmailExistente(Usuario user) {

        boolean validar = false;

        PreparedStatement stm = null;
        ResultSet st;

        try {

            if (cn.getConnection() == null) {

                cn.connect();

            }

            String sql = "SELECT * FROM usuarios where Email = ? ";
            stm = cn.getConnection().prepareStatement(sql);
            stm.setString(1, user.getEmail());

            st = stm.executeQuery();

            if (st.next()) {
                validar = true;
                System.out.println("Correo Existente del usuario  " + st.getString("Email"));
            } else {
                System.out.println("Correo no existente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return validar;

    }

    @Override

    public List<Persona> ListarPorGenero(String cod) {
        List<Persona> lista = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            cn.connect(); // Establece la conexión
            conn = cn.getConnection(); // Obtén la conexión

            // Crear CallableStatement para ejecutar el procedimiento almacenado con el parámetro idPerfil
            cs = conn.prepareCall("{call ListarPerfilesGenero(?)}");
            cs.setString(1, cod); // Establece el parámetro

            // Ejecutar la consulta
            rs = cs.executeQuery();

            // Procesar el ResultSet
            while (rs.next()) {
                lista.add(new Persona(
                        rs.getString("UsuarioID"), // Cambiado a UsuarioID
                        rs.getString("PerfilID"), // Cambiado a PerfilID
                        rs.getString("Nombre"), // Corregidos nombres de columnas
                        rs.getString("Apellido"),
                        rs.getObject("FechaNacimiento", LocalDate.class),
                        rs.getInt("Edad"),
                        rs.getString("Genero"),
                        rs.getBytes("FotoPerfil"),
                        rs.getBytes("FotoPortada"),
                        rs.getBytes("Foto1"),
                        rs.getBytes("Foto2"),
                        rs.getBytes("Foto3"),
                        rs.getString("Ubicacion"),
                        rs.getString("Intereses"),
                        rs.getString("Descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error al listar personas: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    cn.disconnect(); // Desconectar usando el método de desconexión
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return lista;
    }

    @Override
    public Persona InformacionUsuario(String usuarioID) {
        Persona persona = null; // Inicializa persona como null

        try {
            // Asegúrate de que la conexión esté activa.
            if (cn.getConnection() == null) {
                cn.connect();
            }

            String sql = "SELECT * FROM Perfiles WHERE UsuarioID = ?";
            PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, usuarioID); // Usa el parámetro correcto

            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifica si hay resultados en el conjunto de resultados
            if (resultSet.next()) {
                String iduser = resultSet.getString("UsuarioID");
                String idperfil = resultSet.getString("PerfilID");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                LocalDate fechaN = resultSet.getDate("FechaNacimiento").toLocalDate();
                int edad = resultSet.getInt("Edad");
                String genero = resultSet.getString("Genero");
                byte[] fotoPerfil = resultSet.getBytes("FotoPerfil");
                byte[] fotoPortada = resultSet.getBytes("FotoPortada");
                byte[] foto1 = resultSet.getBytes("Foto1");
                byte[] foto2 = resultSet.getBytes("Foto2");
                byte[] foto3 = resultSet.getBytes("Foto3");
                String ubicacion = resultSet.getString("Ubicacion");
                String intereses = resultSet.getString("Intereses");
                String descripcion = resultSet.getString("Descripcion");

                // Crea un nuevo objeto Usuario (o Persona) con los datos obtenidos
                persona = new Persona(iduser, idperfil, nombre, apellido, fechaN, edad, genero, fotoPerfil, fotoPortada, foto1, foto2, foto3, ubicacion, intereses, descripcion);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Asegúrate de manejar la excepción de manera adecuada
        } finally {
            cn.disconnect();
        }

        return persona;
    }

}
