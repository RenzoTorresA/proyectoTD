package TDmain.Libro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDmain.Libro.model.modelAutor;
import TDmain.Libro.repository.IAuhtRepository;

@Service
public class AuthService {
    @Autowired
    IAuhtRepository auhtRepository;

    public List<modelAutor> getAllAutor(){
        return(List<modelAutor>) auhtRepository.findAll();
    }

    public modelAutor saveAutor(modelAutor autor){
        return auhtRepository.save(autor);
    }

    public Optional<modelAutor> getById(Integer id){
        return auhtRepository.findBy(id);
    }

    public modelAutor updateById(modelAutor request, Integer id){
        modelAutor autor = auhtRepository.findById(id).get();

        autor.setNombre(request.getNombre());
        autor.setApellido(request.getApellido());
        autor.setDni(request.getDni());
        autor.setEmails(request.getEmails());

        auhtRepository.save(autor);
        return autor;
    }

    public Boolean deleteAutor(Integer id){
        try{
            auhtRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
