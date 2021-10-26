package hcd.ca.gov.auth.controller;

import hcd.ca.gov.auth.cardatabase.Car;
import hcd.ca.gov.auth.cardatabase.CarRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class HelloController {
    
    @Autowired
    private CarRepository repository;
    


    //@PreAuthorize("hasRole('student')")
    //@RequestMapping("/students")
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloStudent(Authentication authentication) {
        DefaultOidcUser principal = (DefaultOidcUser) authentication.getPrincipal();
        String username = principal.getName();
        return "Welcome User! " + username;
    }
    
    @GetMapping("/name")
    public String user(Principal principal) {
        return principal.getName();
    }
    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
