package App.BusinessLayer.Controllers;

import App.BusinessLayer.Pojo.FavoriteDirectionPOJO;
import App.BusinessLayer.Services.FavoriteDirectionService;
import App.BusinessLayer.Services.UserService;
import App.BusinessLayer.Pojo.UserPOJO;
import App.DataLayer.Models.FavoriteDirectionModel;
import App.DataLayer.Models.UserModel;
import org.springframework.boot.json.JsonParseException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/api/user")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})


public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    //@Autowired
    private UserService userService;

    //@Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder) {
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

    public UserPOJO fillPOJO(UserModel userModel) {
        UserPOJO user = new UserPOJO();
        user.setUserName(userModel.getUserName());
        user.setUserDoc(userModel.getUserDoc());
        user.setUserPhone(userModel.getUserPhone());
        user.setUniversityId(userModel.getUniversityId());
        user.setUserMail(userModel.getUserMail());
        user.setUserAddress(userModel.getUserAddress());
        user.setRegistryDatetime(userModel.getRegistryDatetime());
        user.setPicture(userModel.getPicture());
        user.setRh(userModel.getRh());
        return user;
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    //@GetMapping
    /*public List<UserPOJO> findAll() {
        List<UserPOJO> users = new ArrayList<>();
        List<UserModel> userModels = userService.findAll();
        for (UserModel user : userModels) {
            users.add(fillPOJO(user));
        }
        return users;
    }*/

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/profile")
    public ResponseEntity<UserPOJO> findByUserMail() {

        try {
            String email =
                    SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
            UserModel user = userService.findByUserMail( email );
            return ResponseEntity.ok(fillPOJO(user));
        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping("/signup")
    public ResponseEntity<Void> create(@RequestBody UserPOJO userPOJO) {
        if (userPOJO.getUserName().equals("") || userPOJO.getUserPhone().equals("") || userPOJO.getUserMail().equals("") || userPOJO.getPassword().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            userService.save(fillModel(userPOJO));
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/profile")
    public ResponseEntity<Void> update(@RequestBody UserPOJO userPOJO) {


        try {
            String email =
                    SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
            UserModel user = userService.findByUserMail( email );
            // Busqueda de prueba para saber si el registro ya existe
            UserModel usuarioModel1 =
                    userService.findById(user.getIdUser());
            userService.save(fillModel(userPOJO));
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        try {
            userService.deleteById(id);
            logger.trace(HttpStatus.OK.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }*/

}
