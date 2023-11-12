package TDmain.Libro.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDmain.Libro.model.modelAutor;
import TDmain.Libro.service.AuthService;

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

    @GetMapping(path = "/{id}")
    public Optional<modelAutor> getAutorById(@PathVariable("id") Integer id){
        return this.authService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public modelAutor updateAutorById(@RequestBody modelAutor request, @PathVariable("id") Integer id){
        return this.authService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean eliminar = this.authService.deleteAutor(id);

        if (eliminar) {
            return "USUARIO ID"+ id + " eliminado";
        }else{
            return "ERROR AL ELIMINAR";
        }
    }
}
