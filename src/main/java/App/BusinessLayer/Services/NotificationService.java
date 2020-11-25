package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.NotificationRepository;
import App.DataLayer.Models.NotificationModel;
import App.DataLayer.Models.UserModel;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;

    public List<NotificationModel> findAll(){
        return (List<NotificationModel>) notificationRepository.findAll();
    }

    public NotificationModel findById(int id){
        return notificationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public NotificationModel save(NotificationModel notificationModel){
        return notificationRepository.save(notificationModel);
    }

    public void deleteById(int id){
        notificationRepository.deleteById(id);
    }

    public List<NotificationModel> getNotificationByUser(int userId){
        return notificationRepository.findByidUser(userId);
    }
    
}
