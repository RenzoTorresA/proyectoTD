package TDmain.Libro.Controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TDmain.Libro.dto.AuthRequest;
import TDmain.Libro.model.AutorMappers;
import TDmain.Libro.model.modelAutor;

import TDmain.Libro.service.IAuthService;


@RestController
@RequestMapping("/api/autor")
public class AuthController {
    
    @Autowired
    IAuthService authService;

    @Autowired
    AutorMappers autorMappers;

    @GetMapping("/getAll")
    public List<AuthRequest> getAll(){

            List<modelAutor> autores = authService.findAll();
            return autores.stream().map(autorMappers::entityToDto).collect(Collectors.toList());
        
    }

    @PostMapping("/create")
    public AuthRequest create(@RequestBody AuthRequest authRequest){
        modelAutor autor = autorMappers.dtoToEntity(authRequest);
        autor = authService.add(autor);
        return autorMappers.entityToDto(autor);
        
    }

    @GetMapping("/getById")
    public AuthRequest getById(int id){
        modelAutor autor = authService.findById(id);
        return autorMappers.entityToDto(autor);
    }

    @PutMapping("/update")
    public AuthRequest update(@RequestBody AuthRequest authRequest){
        modelAutor autor = autorMappers.dtoToEntity(authRequest);
        autor = authService.update(autor);
        return autorMappers.entityToDto(autor);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(int id){
        return authService.delete(id);
    }
}
