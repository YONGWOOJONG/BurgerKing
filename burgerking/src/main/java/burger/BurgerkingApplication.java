package burger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import burger.BurgerkingApplication;

@SpringBootApplication
public class BurgerkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerkingApplication.class, args);
	}

	@Bean 
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}