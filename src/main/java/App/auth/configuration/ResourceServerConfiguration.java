package App.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String[] publicResources =
            new String[]{"/api/user/signup"};
    private static final String[] userResources = new String[]{"/api/vehicle" +
            "/**", "/api/ride/**", "/api/user"};

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(publicResources).permitAll()
                .antMatchers(userResources).authenticated()
                .and().cors().disable();
    }

}