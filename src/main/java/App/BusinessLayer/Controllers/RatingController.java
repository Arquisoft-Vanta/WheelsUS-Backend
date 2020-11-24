package App.BusinessLayer.Controllers;

import App.BusinessLayer.Pojo.FastProfilePOJO;
import App.BusinessLayer.Pojo.RatingPOJO;
import App.BusinessLayer.Pojo.UserRatingPOJO;
import App.BusinessLayer.Services.RatingService;
import App.BusinessLayer.Services.UserService;
import App.DataLayer.Models.RatingModel;
import App.DataLayer.Models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})
public class RatingController {
    Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    private RatingService ratingService;
    private UserService userService;

    public RatingController(RatingService ratingService,
                            UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    public RatingModel fillModel(RatingPOJO ratingPOJO) {
        RatingModel ratingModel = new RatingModel();
        ratingModel.setGrade(ratingPOJO.getGrade());
        int graded = userService.findByUserMail(ratingPOJO.getGraded()).getIdUser();
        ratingModel.setGraded(graded);
        int grader =
                userService.findByUserMail(ratingPOJO.getGrader()).getIdUser();
        ratingModel.setGrader(grader);
        ratingModel.setRideId(ratingPOJO.getRideId());
        return ratingModel;
    }

    public RatingPOJO fillPOJO(RatingModel ratingModel) {
        RatingPOJO ratingPOJO = new RatingPOJO();
        ratingPOJO.setGrade(ratingModel.getGrade());
        ratingPOJO.setGraded(userService.findById(ratingModel.getGraded()).getUserMail());
        ratingPOJO.setGrader(userService.findById(ratingModel.getGrader()).getUserMail());
        ratingPOJO.setRideId(ratingModel.getRideId());
        return ratingPOJO;
    }

    public UserRatingPOJO fillUserRating(float rating) {
        UserRatingPOJO userRatingPOJO = new UserRatingPOJO();
        userRatingPOJO.setRating(rating);
        return userRatingPOJO;
    }

    // Obtener la calificacion numerica de un usuario basado en su correo
    @GetMapping
    public ResponseEntity<UserRatingPOJO> getRatingByEmail(@RequestParam String userEmail) {
        try {

            try {
                String email =
                        SecurityContextHolder.getContext().getAuthentication().getName();
            } catch (EntityNotFoundException e) {
                logger.error(HttpStatus.UNAUTHORIZED.toString());
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            UserModel user = userService.findByUserMail(userEmail);
            float rating = ratingService.getAverageRating(user.getIdUser());
            return ResponseEntity.ok(fillUserRating(rating));


        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException | NullPointerException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RatingPOJO ratingPOJO) {

        try {
            ratingService.save(fillModel(ratingPOJO));
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
