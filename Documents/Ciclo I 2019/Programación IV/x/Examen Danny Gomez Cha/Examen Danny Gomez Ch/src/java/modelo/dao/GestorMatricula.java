/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Matricula;

/**
 *
 * @author Rache Basulto
 */
public class GestorMatricula implements Serializable{
    private static GestorMatricula instancia = null;
    
    //Base de datos
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_prc1?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARMATRICULA = "SELECT codigo, nombre, creditos FROM eif209_prc1.matricula, eif209_prc1.curso "
                                                    + "WHERE estudiante_id = '%s' AND curso_codigo = codigo;";
    private static final String CMD_MATRICULAR = "INSERT INTO eif209_prc1.matricula (estudiante_id, curso_codigo) VALUES('%s','%s');";
    private static final String CMD_DESMATRICULAR = "DELETE FROM eif209_prc1.matricula WHERE estudiante_id = '%s' AND curso_codigo = '%s';";
    

    
    public GestorMatricula(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorMatricula obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorMatricula();
        
        return instancia;
    }
    
    public List<Matricula> listarCursos(){
        List<Matricula> lista = new ArrayList<>();
        Login logged = GestorLogin.obtenerInstancia().loggeado;
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(String.format(CMD_LISTARMATRICULA, logged.getId()));)
        {
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                lista.add(new Matricula(codigo, nombre, creditos));                
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public void matricular(String codigo){
        Login logged = GestorLogin.obtenerInstancia().loggeado;
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            stm.executeUpdate(String.format(CMD_MATRICULAR, logged.getId(), codigo));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
    }
    
    public void desmatricular(String codigo){
        Login logged = GestorLogin.obtenerInstancia().loggeado;
        
         try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            stm.executeUpdate(String.format(CMD_DESMATRICULAR, logged.getId(), codigo));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
}
