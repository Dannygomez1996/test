
package modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;
import modelo.Login;

/**
 *
 * @author Danny Gomez Chaves
 */

public class GestorEstudiantes implements Serializable{
    private static GestorEstudiantes instancia = null;
    
    //Bases de datos
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_prc1?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARESTUDIANTES = "SELECT id, apellido1, apellido2, nombre, email, clave, telefono, direccion FROM eif209_prc1.estudiante";
    public Connection conn;
    
    public GestorEstudiantes(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorEstudiantes obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorEstudiantes();
        
        return instancia;
    }
    
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARESTUDIANTES);)
        {
            while(rs.next()){
                String id = rs.getString("id");
                String ap1 = rs.getString("apellido1");
                String ap2 = rs.getString("apellido2");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String clave = rs.getString("clave");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                lista.add(new Estudiante(id, ap1, ap2, nombre, email, clave, telefono, direccion));                
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public String getDatosEstudiante(){
        StringBuilder str = new StringBuilder();
        List<Estudiante> listaEstudiantes = this.listarEstudiantes();
        Login loggeado = GestorLogin.obtenerInstancia().loggeado;
        
        for(Estudiante e : listaEstudiantes){
            if(e.getId().equals(loggeado.getId())){
                str.append("<label>Id: </label>" + " " + String.format("<p><strong>%s</strong></p>", e.getId()));
                str.append("<label>Nombre: </label>" + " " + String.format("<p><strong>%s</strong></p>", e.getNombre() +" "+ e.getApellido1() + " " + e.getApellido2()));
                str.append("<label>E-mail: </label>"+ " " +String.format("<p><strong>%s</strong></p>", e.getEmail()));
                str.append("<label>Telefono: </label>"+ " " +String.format("<p><strong>%s</strong></p>", e.getTelefono()));
                str.append("<label>Direccion: </label>"+ " " +String.format("<p><strong>%s</strong></p>", e.getDireccion()));
            }
        }
        
        return str.toString();
    }
}
