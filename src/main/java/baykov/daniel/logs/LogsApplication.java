package baykov.daniel.logs;

import baykov.daniel.logs.swagger.MainOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MainOpenApi
@SpringBootApplication
public class LogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogsApplication.class, args);
	}

}
