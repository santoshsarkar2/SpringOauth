package hcd.ca.gov.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.servlet.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
// public class AcademyApplication extends SpringBootServletInitializer {
public class AuthApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthApplication.class);
    }
//    public static void main(String[] args) {
//	SpringApplication.run(AuthApplication.class, args);
// }

}



