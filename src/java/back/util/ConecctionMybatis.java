/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.util;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author juang
 */
public class ConecctionMybatis {
     // La ubicación del archivo de configuración de MyBatis.
   // private String resource = "mybatis/mybatis-config.xml";
     private String resource = "mybatis/mybatis-config.xml";

    // Objeto que representa la sesión de MyBatis. Se inicializa en null.
    private SqlSession session = null;

    /**
     * El método getSession se encarga de crear y devolver una instancia de SqlSession
     * utilizando la configuración especificada en "mybatis-config.xml".
     *
     * @return Una instancia de SqlSession que se puede utilizar para interactuar con la base de datos.
     */
    public SqlSession getSession() {

        try {
            // Lee el archivo de configuración de MyBatis (mybatis-config.xml) utilizando un Reader.
            Reader reader = Resources.getResourceAsReader(resource);
            
            // Construye la fábrica de sesiones (SqlSessionFactory) utilizando el archivo de configuración.
            SqlSessionFactory mapeo = new SqlSessionFactoryBuilder().build(reader);
            
            // Abre una nueva sesión de MyBatis a partir de la fábrica de sesiones.
            session = mapeo.openSession();
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            // Si ocurre algún error, se imprime el hashCode del error y el stack trace para depuración.
            System.out.println(e.hashCode());
            e.printStackTrace();
        }

        // Devuelve la sesión de MyBatis creada.
        return session;
    }
}
