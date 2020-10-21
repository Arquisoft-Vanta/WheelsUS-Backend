/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.UserService;
import App.BusinessLayer.Pojo.UserPOJO;
import App.DataLayer.Models.UserModel;
import org.springframework.boot.json.JsonParseException;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/api/user")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})


public class UserController {
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    //@Autowired
    private UserService userService;

    //@Autowired
    private PasswordEncoder passwordEncoder;

    public UserController( UserService userService,  PasswordEncoder passwordEncoder ){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel fillModel(UserPOJO userPOJO) {
        UserModel user = new UserModel();
        user.setUserName(userPOJO.getUserName());
        user.setUserDoc(userPOJO.getUserDoc());
        user.setUserPhone(userPOJO.getUserPhone());
        user.setUniversityId(userPOJO.getUniversityId());
        user.setUserMail(userPOJO.getUserMail());
        user.setUserAddress(userPOJO.getUserAddress());
        user.setPassword(passwordEncoder.encode(userPOJO.getPassword()));
        user.setRegistryDatetime(userPOJO.getRegistryDatetime());
        user.setPicture(userPOJO.getPicture());
        user.setRh(userPOJO.getRh());
        return user;
    }

    public UserPOJO fillPOJO(UserModel userModel){
        UserPOJO user = new UserPOJO();
        user.setUserName(userModel.getUserName());
        user.setUserDoc(userModel.getUserDoc());
        user.setUserPhone(userModel.getUserPhone());
        user.setUniversityId(userModel.getUniversityId());
        user.setUserMail(userModel.getUserMail());
        user.setUserAddress(userModel.getUserAddress());
        user.setPassword(userModel.getPassword());
        user.setRegistryDatetime(userModel.getRegistryDatetime());
        user.setPicture(userModel.getPicture());
        user.setRh(userModel.getRh());
        return user;
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<UserPOJO> findAll() {
        List<UserPOJO> users = new ArrayList<>();
        List<UserModel> userModels = userService.findAll();
        for (UserModel user:userModels) {
            users.add(fillPOJO(user));
        }
        return users;
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<UserPOJO> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(fillPOJO(userService.findById(id)));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserPOJO userPOJO) {
        userService.save(fillModel(userPOJO));
        return new ResponseEntity<>(HttpStatus.CREATED);
        /*
        try {
            UserPOJO userPOJO = fillPOJO(userModel);
            userService.save(fillModel(userPOJO));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
    }


    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserPOJO userPOJO) {
        try {
            // Busqueda de prueba para saber si el registro ya existe
            UserModel usuarioModel1 =
                    userService.findById(userPOJO.getIdUser());
            userService.save(fillModel(userPOJO));
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (JsonParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (JsonParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
