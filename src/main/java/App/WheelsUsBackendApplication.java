package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WheelsUsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WheelsUsBackendApplication.class, args);
                
	}

}
