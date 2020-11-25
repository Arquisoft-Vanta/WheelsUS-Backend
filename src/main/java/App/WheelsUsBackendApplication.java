package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication()
public class WheelsUsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WheelsUsBackendApplication.class, args);
                
	}

}
