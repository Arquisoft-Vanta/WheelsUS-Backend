package App.auth.model;


import App.DataLayer.Models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserDetailsImpl implements UserDetails{

    private String userMail;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl( UserModel user ){
        this.userMail = user.getUserMail( );
        this.password = user.getPassword( );
        //this.authorities = translateRoles( user.getRoles( ) );
    }

    @Override
    public String getUsername( ){
        return userMail;
    }

    @Override
    public String getPassword( ){
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( ){
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired( ){
        return true;
    }

    @Override
    public boolean isAccountNonLocked( ){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired( ){
        return true;
    }

    @Override
    public boolean isEnabled( ){
        return true;
    }
    
}
