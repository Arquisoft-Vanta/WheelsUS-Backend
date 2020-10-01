package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.ExampleService;
import App.DataLayer.Models.ExampleModel;
import org.springframework.boot.json.JsonParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/example")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

public class ExampleController {
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    @Autowired
    private ExampleService exampleService;

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<ExampleModel> findAll() {
        return exampleService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<ExampleModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(exampleService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<ExampleModel> create(@RequestBody ExampleModel exampleModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(exampleService.save(exampleModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping
    public ResponseEntity<ExampleModel> update(@RequestBody ExampleModel exampleModel) {
        try {
            // Busqueda de prueba para saber si el registro ya existe
            ExampleModel exampleModel1
                    = exampleService.findById(exampleModel.getIdExample());
            return ResponseEntity.status(HttpStatus.CREATED).body(exampleService.save(exampleModel));

        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<ExampleModel> deleteById(@PathVariable int id) {

        try {
            exampleService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
