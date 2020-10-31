/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.DataLayer.Models.UserModel;
import javax.persistence.EntityNotFoundException;
import App.BusinessLayer.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){
        return (List<UserModel>) userRepository.findAll();
    }

    public UserModel findById(int id){
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public UserModel save(UserModel touristModel){
        return userRepository.save(touristModel);
    }
    public UserModel findByUserMail( String userMail ){
        return userRepository.findByuserMail( userMail );
    }
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
