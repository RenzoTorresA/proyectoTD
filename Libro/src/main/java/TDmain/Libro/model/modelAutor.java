package TDmain.Libro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="autores")
public class modelAutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idautores")
    public int idautorres;

    @Column(name="nombre")
    public String nombre;

    @Column(name="apellido")
    public String apellido;

    @Column(name="dni")
    public String dni;

    @Column(name="emails")
    public String emails;

    public int getIdautorres() {
        return idautorres;
    }

    public void setIdautorres(int idautorres) {
        this.idautorres = idautorres;
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
