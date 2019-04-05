
package modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;

/**
 *
 * @author Danny Gomez Chaves
 */

public class GestorCursos implements Serializable{
    
    private static GestorCursos instancia = null;
    
    //Base de datos
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_prc1?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARCURSOS = "SELECT codigo, nombre, creditos FROM eif209_prc1.curso ORDER BY codigo";
    
    public GestorCursos(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorCursos obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorCursos();
        return instancia;
    }
    
    public List<Curso> listarCursos(){
        List<Curso> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARCURSOS);)
        {
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                lista.add(new Curso(codigo, nombre, creditos));                
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    
}
