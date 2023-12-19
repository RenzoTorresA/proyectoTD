package TDmain.Libro.model;

import TDmain.Libro.dto.AuthRequest;

public class AutorMappers {
 
    
    public AuthRequest entityToDto(modelAutor autor){
        AuthRequest dto = new AuthRequest();
        dto.setApellido(autor.getApellido());
        dto.setDni(autor.getDni());
        dto.setEmails(autor.getEmails());
        dto.setNombre(autor.getNombre());
        return dto;
    }

    public modelAutor dtoToEntity(AuthRequest dto){
        modelAutor autor = new modelAutor();
        autor.setApellido(dto.getApellido());
        autor.setDni(dto.getDni());
        autor.setEmails(dto.getEmails());
        autor.setNombre(dto.getNombre());
        return autor;
    }
}
