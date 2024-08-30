/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GRABIEL
 */
public class ConectarBD {
     // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/CitaMatch";
    // Nombre de usuario de la base de datos
    private static final String USER = "root";
    // Contraseña de la base de datos
    private static final String PASSWORD = "1212";
    
    // Conexión a la base de datos
    private Connection connection;

    // Método para conectar a la base de datos
    public void connect() {
        try {
            // Registrar el driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");
            System.out.println("Base de datos: " + getDatabaseName());
            System.out.println("Usuario: " + USER);
            // No se muestra la contraseña por razones de seguridad
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    // Método para desconectar de la base de datos
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Desconexión establecida con éxito.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Obtener el nombre de la base de datos desde la conexión
    private String getDatabaseName() {
        try {
            return connection.getCatalog();
        } catch (SQLException e) {
            System.err.println("Error al obtener el nombre de la base de datos: " + e.getMessage());
            return "Desconocido";
        }
    }

    // Obtener la conexión actual
    public Connection getConnection() {
        return connection;
    }

    
}
