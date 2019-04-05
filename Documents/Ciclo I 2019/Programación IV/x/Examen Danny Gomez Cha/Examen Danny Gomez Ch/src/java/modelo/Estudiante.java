
package modelo;

import java.io.Serializable;

/**
 *
 * @author Danny Gomez Chaves
 */

public class Estudiante implements Serializable{
    String id, apellido1, apellido2, nombre, email, clave, telefono, direccion;
    
    public Estudiante(){
       
    }
    
    
    public Estudiante(String id, String ap1, String ap2, String nombre, String email, String clave, String telefono, String direccion){
        this.id = id;
        this.apellido1 = ap1;
        this.apellido2  = ap2;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
