package App.auth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

    private static final String TRUSTED_CLIENT = "wheels-us";
    private static final String SECRET = "dragonfly-software";
    private static final String[] AUTHORIZED_GRANT_TYPES = new String[]{ "client_credentials", "password" };
    private static final String[] SCOPES = new String[]{ "read", "write", "trust" };
    private static final String[] RESOURCE_IDS = new String[] { "oauth2-resource" };
    private static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1600;


    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public AuthorizationServerConfiguration( AuthenticationManager authenticationManager,
                                             PasswordEncoder passwordEncoder ){
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void configure( AuthorizationServerSecurityConfigurer security ){
        security
                .checkTokenAccess( "isAuthenticated()" );
    }

    @Override
    public void configure( AuthorizationServerEndpointsConfigurer endpoints ){
        endpoints.authenticationManager( authenticationManager );
        endpoints.tokenStore( getTokenStore( ) );
    }

    @Override
    public void configure( ClientDetailsServiceConfigurer client ) throws Exception{
        client.inMemory( )
                .withClient( TRUSTED_CLIENT )
                .authorizedGrantTypes( AUTHORIZED_GRANT_TYPES ).scopes( SCOPES )
                .resourceIds( RESOURCE_IDS ).accessTokenValiditySeconds( ACCESS_TOKEN_VALIDITY_SECONDS )
                .secret( passwordEncoder.encode( SECRET ) );
    }

    @Bean
    public TokenStore getTokenStore( ){
        return new InMemoryTokenStore( );
    }
}
