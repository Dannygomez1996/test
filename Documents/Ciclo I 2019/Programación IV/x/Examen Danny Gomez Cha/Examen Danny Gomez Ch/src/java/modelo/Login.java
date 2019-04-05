
package modelo;

import java.io.Serializable;

/**
 *
 * @author Danny Gomez Chaves
 */

public class Login implements Serializable{
    private String id;
    private String clave;
    
    public Login(){
        this.id = null;
        this.clave = null;
    }
    
    public Login(String id, String clave){
        this.id = id;
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
