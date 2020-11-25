/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Repositories;

import App.DataLayer.Models.NotificationModel;
import App.DataLayer.Models.UserModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface NotificationRepository extends CrudRepository<NotificationModel, Integer> {

    public List<NotificationModel> findByidUser(int idUser);
    
}
