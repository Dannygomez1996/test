
package modelo;

import java.io.Serializable;

/**
 *
 * @author Danny Gomez Chaves
 */

public class Matricula implements Serializable{
    String codigo;
    String nombre;
    int creditos;
    
    public Matricula(){
        this.codigo = null;
        this.nombre = null;
        this.creditos = 0;
    }
    
    public Matricula(String codigo, String nombre, int creditos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    
    
}
