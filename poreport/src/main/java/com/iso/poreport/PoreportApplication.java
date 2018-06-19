package com.iso.poreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PoreportApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PoreportApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(PoreportApplication.class, args);
	}
}
/*public class PoreportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoreportApplication.class, args);
	}
}*/
