/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.UserService;
import App.DataLayer.Models.UserModel;
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
@RequestMapping("/api/user")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})


public class UserController {
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    @Autowired
    private UserService userService;

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
        try {
            // Busqueda de prueba para saber si el registro ya existe
            UserModel usuarioModel1
                    = userService.findById(userModel.getIdUser());
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));

        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteById(@PathVariable int id) {

        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
