package TDmain.Libro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDmain.Libro.model.modelAutor;
import TDmain.Libro.repository.IAuhtRepository;

@Service
public class AuthService implements IAuthService {
    @Autowired
    IAuhtRepository auhtRepository;

    @Override
    public List<modelAutor> findAll() {
        return (List<modelAutor>) auhtRepository.findAll();
    }

    @Override
    public modelAutor add(modelAutor autor){
        return auhtRepository.save(autor);
    }

    @Override
    public modelAutor findById(int id) {
        Optional<modelAutor> autor = auhtRepository.findById(id);
        return autor.get();
    }

    @Override
    public modelAutor update(modelAutor autor) {

        return auhtRepository.save(autor);

    }

    @Override
    public boolean delete(int id) {
        try {
            auhtRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
