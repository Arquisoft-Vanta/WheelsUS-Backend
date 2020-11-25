package App.BusinessLayer.Controllers;

import App.BusinessLayer.Pojo.FastProfilePOJO;
import App.BusinessLayer.Pojo.FavoriteDirectionPOJO;
import App.BusinessLayer.Services.FavoriteDirectionService;
import App.BusinessLayer.Services.RatingService;
import App.BusinessLayer.Services.UserService;
import App.BusinessLayer.Pojo.UserPOJO;
import App.DataLayer.Models.FavoriteDirectionModel;
import App.DataLayer.Models.UserModel;
import org.springframework.boot.json.JsonParseException;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.xml.soap.Text;

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

    private RatingService ratingService;

    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder, RatingService ratingService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.ratingService = ratingService;
    }
/*
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
    public UserModel updateModel(UserPOJO userPOJO, UserModel user) {
        if (userPOJO.getUserName()!=null) {
            user.setUserName(userPOJO.getUserName());
        }
        if (userPOJO.getUserDoc() != null) {
            user.setUserDoc(userPOJO.getUserDoc());
        }
        if (userPOJO.getUserPhone() != null) {
            user.setUserPhone(userPOJO.getUserPhone());
        }
        if (userPOJO.getUniversityId() != user.getUniversityId()) {
            user.setUniversityId(userPOJO.getUniversityId());
        }
        if (userPOJO.getUserMail() != null) {
            user.setUserMail(userPOJO.getUserMail());
        }
        if(userPOJO.getUserAddress() != null) {
            user.setUserAddress(userPOJO.getUserAddress());
        }
        if(userPOJO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userPOJO.getPassword()));
        }
        if(userPOJO.getRegistryDatetime() != null) {
            user.setRegistryDatetime(userPOJO.getRegistryDatetime());
        }
        if(userPOJO.getPicture() != null) {
            user.setPicture(userPOJO.getPicture());
        }
        if(userPOJO.getRh() != null) {
            user.setRh(userPOJO.getRh());
        }
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
    }*/


    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/profile")
    public ResponseEntity<UserPOJO> findByUserMail() {

        try {
            String email = "";
            try {
                email =
                        SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
            }catch (EntityNotFoundException e){
                logger.error(HttpStatus.UNAUTHORIZED.toString());
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            UserModel user = userService.findByUserMail( email );
            String profilePic = user.getPicture();

            if(!profilePic.equals("")){

                String data = "";
                String os = System.getProperty("os.name");

                if (os.equals("Windows 10")){

                    String picAddres = "C:\\Users\\sebas\\Documents\\Codigos\\WheelsUN\\WheelsUS-Backend\\pictures\\profile\\" + email + ".txt";
                    File base64 = new File(picAddres);
                    Scanner myReader = new Scanner(base64);

                    while (myReader.hasNextLine()) {
                        data = myReader.nextLine();
                    }
                    myReader.close();
                    user.setPicture(data);

                }else{
                    String picAddres = "../../../pictures/profile/" + email + ".txt";
                    File base64 = new File(picAddres);
                    Scanner myReader = new Scanner(base64);
                    while (myReader.hasNextLine()) {
                        data = myReader.nextLine();
                    }
                    myReader.close();

                    user.setPicture(data);
                }
            }

            return ResponseEntity.ok(new UserPOJO(user));
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

    public FastProfilePOJO fillFastProfile(float rating, UserModel userModel){
        FastProfilePOJO fastProfilePOJO = new FastProfilePOJO();
        fastProfilePOJO.setPicture(userModel.getPicture());
        fastProfilePOJO.setUserMail(userModel.getUserMail());
        fastProfilePOJO.setUserName(userModel.getUserName());
        fastProfilePOJO.setUserPhone(userModel.getUserPhone());
        fastProfilePOJO.setRate(rating);
        return fastProfilePOJO;
    }

    @GetMapping("/fast-profile")
    public ResponseEntity<FastProfilePOJO> getFastProfileByEmail(@RequestParam String userMail) {
        try {
            try {
                String email =
                        SecurityContextHolder.getContext().getAuthentication().getName();
            } catch (EntityNotFoundException e) {
                logger.error(HttpStatus.UNAUTHORIZED.toString());
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            UserModel user = userService.findByUserMail(userMail);
            logger.info(String.valueOf(user.getIdUser()));
            float rating = ratingService.getAverageRating(user.getIdUser());
            return ResponseEntity.ok(fillFastProfile(rating, user));


        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException | NullPointerException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping("/signup")
    public ResponseEntity<Void> create(@RequestBody UserPOJO userPOJO) {
        if (userPOJO.getUserName().equals("") || userPOJO.getUserPhone().equals("") || userPOJO.getUserMail().equals("") || userPOJO.getPassword().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            userService.save(userPOJO.getModel(passwordEncoder));
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
            String email = "";
            try {
                 email =
                        SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
            }catch (EntityNotFoundException e){
                logger.error(HttpStatus.UNAUTHORIZED.toString());
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            UserModel user = userService.findByUserMail( email );
            String imgSelected = userPOJO.getPicture();

            if (!imgSelected.equals("")){

                String fileName = email + ".txt";

                String os = System.getProperty("os.name");

                if (os.equals("Windows 10")){

                    String picRoute = "C:\\Users\\sebas\\Documents\\Codigos\\WheelsUN\\WheelsUS-Backend\\pictures\\profile\\" + fileName;
                    File myObj = new File(picRoute);
                    FileWriter wrt = new FileWriter(picRoute);
                    wrt.write(imgSelected);
                    wrt.close();
                    userPOJO.setPicture(picRoute);

                }else{
                    String picRoute = "../../../pictures/profile/" + fileName;
                    File myObj = new File(picRoute);
                    FileWriter wrt = new FileWriter(picRoute);
                    wrt.write(imgSelected);
                    wrt.close();
                    userPOJO.setPicture(picRoute);
                }

            }

            userService.save(userPOJO.updateModel(passwordEncoder, user));
            //updateModel(userPOJO,
            // user));
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
