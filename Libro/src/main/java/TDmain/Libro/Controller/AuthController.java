package TDmain.Libro.Controller;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import TDmain.Libro.ControllerEx.ApiResponse;
import TDmain.Libro.dto.AuthRequest;

import TDmain.Libro.model.AutorMappers;
import TDmain.Libro.model.UsuarioNotFoundException;
import TDmain.Libro.model.modelAutor;

import TDmain.Libro.service.IAuthService;



@RestController
@RequestMapping("/api/autor")
public class AuthController {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    IAuthService authService;

    @Autowired
    AutorMappers autorMappers;

    @GetMapping("/getAll")
<<<<<<< Updated upstream
    public ResponseEntity<ApiResponse<List<AuthRequest>>> getAll(){

           try{
            List<modelAutor> autores = authService.findAll();
            List<AuthRequest> authRequests = autores.stream()
            .map(autorMappers::entityToDto).collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(),
             "consulta exitosa", authRequests));
        }catch(Exception ex){
            logger.error("Error en el metodo getAll", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            "Error al procesar la solicitud", null));
           } 
        
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AuthRequest>> create(@RequestBody AuthRequest authRequest){
        try{
            modelAutor autores = autorMappers.dtoToEntity(authRequest);
            autores = authService.add(autores);
            AuthRequest creaAuthRequest = autorMappers.entityToDto(autores);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(HttpStatus.CREATED.value(), "Usuario Creado", creaAuthRequest));
        }catch(Exception ex){
            logger.error("Error en el metodo CREATE", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Crear", null));
        }
        
    }

    @GetMapping("/getById")
    public ResponseEntity<ApiResponse<AuthRequest>> getById(@RequestParam int id){
        try{
            modelAutor autores = authService.findById(id);
            if (autores !=null) {
                AuthRequest authRequest = autorMappers.entityToDto(autores);
                return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Consulta de Busqueda por ID extitosa", authRequest));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Usuario no creado",null ));
            }
        }catch(Exception ex){
            logger.error("Error en el metodo getById", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            "Error al Buscar Autor" , null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<AuthRequest>> update(@RequestBody AuthRequest authRequest){
        try{
            // Llamada al servicio para actualizar el usuario
            modelAutor autores = authService.update(autorMappers.dtoToEntity(authRequest));
            // Construir la respuesta exitosa
            AuthRequest actualizarAuthRequest = autorMappers.entityToDto(autores);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Usuario actualizado", actualizarAuthRequest));
        }catch(UsuarioNotFoundException ex){
            logger.error("Error al actualizar Autor", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
        }
        catch(Exception ex){
            logger.error("Error en el metodo UPDATE", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Error al actulizar Autor", null));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable int id){
        try{
            // Llamada al servicio para eliminar el usuario
            boolean elimminar = authService.delete(id);

            if (elimminar) {
                return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Usuario Eliminado correctamente", null));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), 
                "No se Encontro Autor a eliminar", null));
            }
        }catch(Exception ex){
            // Registrar el error utilizando SLF4J
            logger.error("Error en el metodo DELETE", ex);

            // Manejar otras excepciones y devolver una respuesta 500 Internal Server Error con un mensaje genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            "Error al aliminar usuario", null));
=======
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
>>>>>>> Stashed changes
        }
    }
}
