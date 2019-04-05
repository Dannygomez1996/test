
package modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Login;


/**
 *
 * @author Danny Gomez Chaves
 */

public class GestorLogin implements Serializable{
    private static GestorLogin instancia = null;
    public Login loggeado = null;
    
    //Bases de datos
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_prc1?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_USUARIO = "SELECT id, clave FROM eif209_prc1.estudiante";
    public Connection conn;
    
     public GestorLogin(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
    }
    
    public static GestorLogin obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorLogin();
        
        return instancia;
    }

    public List<Login> listarLogin() {
        
        List<Login> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_USUARIO);)
        {
            while(rs.next()){
                String id = rs.getString("id");
                String clave = rs.getString("clave");
                lista.add(new Login(id, clave));                
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public boolean validateLogin(String username, String pass){
        List<Login> lista = this.listarLogin();
        boolean validate = false;
        
        for(Login l : lista){
            if(l.getId().equals(username) && l.getClave().equals(pass)){
                validate = true;
                this.loggeado = l;
            }
        }
        return validate;
    }
    
    
}

