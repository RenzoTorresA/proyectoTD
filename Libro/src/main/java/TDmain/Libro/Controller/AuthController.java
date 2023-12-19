package TDmain.Libro.Controller;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import TDmain.Libro.model.modelAutor;

import TDmain.Libro.service.IAuthService;


@RestController
@RequestMapping("/api/autor")
public class AuthController {
    
    @Autowired
    AuthService authService;

    @GetMapping
    public List<modelAutor> get(){
        return authService.getAllAutor();
    }

    @PostMapping
    public modelAutor saveAutor(@RequestBody modelAutor autor){
        return this.authService.saveAutor(autor);
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

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean eliminar = this.authService.deleteAutor(id);

        if (eliminar) {
            return "Usuario con ID "+ id + " eliminado";
        }else{
            return "error al eliminar";
        }
    }
}
