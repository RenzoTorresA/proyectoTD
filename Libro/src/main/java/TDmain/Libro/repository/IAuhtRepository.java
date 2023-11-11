package TDmain.Libro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDmain.Libro.model.modelAutor;

@Repository
public interface IAuhtRepository extends CrudRepository<modelAutor,Integer>{
    
}
