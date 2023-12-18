package TDmain.Libro.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import TDmain.Libro.model.modelAutor;
import TDmain.Libro.service.AuthService;

@RestController
@RequestMapping("/api/autor")
public class AuthController {
    
    @Autowired
    AuthService authService;

    @GetMapping
    public List<modelAutor> get() {
        try {
            return authService.getAllAutor();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

  @PostMapping
public ResponseEntity<modelAutor> saveAutor(@RequestBody modelAutor autor) {
    try {
        modelAutor savedAutor = this.authService.saveAutor(autor);
        return new ResponseEntity<>(savedAutor, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AuthService authService;

   
    public AutorController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public modelAutor saveAutor(@RequestBody modelAutor autor) {
        try {
            return this.authService.saveAutor(autor);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el autor", e);
        }
    }

    @GetMapping("/getAll")
    public List<modelAutor> get() {
        try {
            return this.authService.getAllAutor();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener la lista de autores", e);
        }
    }
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
