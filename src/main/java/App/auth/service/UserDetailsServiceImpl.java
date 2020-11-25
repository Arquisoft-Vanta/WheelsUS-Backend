package App.auth.service;


import App.BusinessLayer.Services.UserService;
import App.DataLayer.Models.UserModel;
import App.auth.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userMail) {
        UserModel user = userService.findByUserMail(userMail);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return new UserDetailsImpl(user);
    }

}