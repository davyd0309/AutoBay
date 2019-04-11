package pl.witkowski.AutoBay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AutoBayApplication extends SpringBootServletInitializer {

//	public static void main(String[] args) {
//		SpringApplication.run(AutoBayApplication.class, args);
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AutoBayApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AutoBayApplication.class, args);
	}

}
