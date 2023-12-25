package biblioexp.bibleo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("biblioexp.bibleo")
public class BibleoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibleoApplication.class, args);
	}

}
