/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Pojo.NotificationPOJO;
import App.BusinessLayer.Services.NotificationService;
import App.BusinessLayer.Services.UserService;
import App.DataLayer.Models.NotificationModel;
import App.DataLayer.Models.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 */

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})
public class NotificationController {
    
    Logger logger = LoggerFactory.getLogger(NotificationController.class);
    
    @Autowired
    private NotificationService notificationService;
    private UserService userService;
    
    public NotificationController(NotificationService notificationService, UserService userService){
        this.notificationService = notificationService;
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<NotificationPOJO>> getNotifications(){
    
        try {
            String email = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
            UserModel user = userService.findByUserMail( email );
            ArrayList<NotificationModel> lista = (ArrayList<NotificationModel>) notificationService.getNotificationByUser(user.getIdUser());
            ArrayList<NotificationPOJO> listapojo = new ArrayList<>();
            for (NotificationModel notificationModel : lista) {
                listapojo.add(new NotificationPOJO(notificationModel));
                logger.error(listapojo.toString());
            }
            return ResponseEntity.ok(listapojo);
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
    
    @PostMapping
    public ResponseEntity<Void> createNotification(@RequestBody NotificationPOJO notificationPojo){
        
        try {
            UserModel user = userService.findByUserMail(notificationPojo.getMailUser());
            notificationPojo.setIdUser(user.getIdUser());
            notificationService.save(notificationPojo.getModel());
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }
}
