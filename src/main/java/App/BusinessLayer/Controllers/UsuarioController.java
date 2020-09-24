/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.UsuarioService;
import App.DataLayer.Models.ExampleModel;
import App.DataLayer.Models.UsuarioModel;
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
@RequestMapping("/Usuario")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})


public class UsuarioController {
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    @Autowired
    private UsuarioService usuarioService;

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<UsuarioModel> findAll() {
        return usuarioService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(usuarioService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<UsuarioModel> create(@RequestBody UsuarioModel usuarioModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> update(@RequestBody UsuarioModel usuarioModel) {
        try {
            // Busqueda de prueba para saber si el registro ya existe
            UsuarioModel usuarioModel1
                    = usuarioService.findById(usuarioModel.getIdUsuario());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));

        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioModel> deleteById(@PathVariable int id) {

        try {
            usuarioService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
