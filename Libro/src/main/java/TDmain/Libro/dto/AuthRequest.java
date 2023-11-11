package TDmain.Libro.dto;

import java.io.Serializable;

public class AuthRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private String dni;
    private String emails;


    public AuthRequest() {

    }


    public AuthRequest(String nombre, String apellido, String dni, String emails) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setEmails(emails);
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getEmails() {
        return emails;
    }


    public void setEmails(String emails) {
        this.emails = emails;
    }
    
    

    
}
