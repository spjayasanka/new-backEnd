package com.example.demo.controller;

import com.example.demo.Config.Iconstants;
import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.dto.CustomerLoginDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(value = "/token")
    public ResponseEntity<String> getToken(@RequestBody CustomerLoginDTO login) throws ServletException {

        Customer customer = customerRepo.findByEmail(login.getUsername());

        String jwttoken = "";

        if(login.getUsername().isEmpty() || login.getPassword().isEmpty())
            return new ResponseEntity<String>("Username or password cannot be empty.", HttpStatus.BAD_REQUEST);

        String name = login.getUsername(),
                password = login.getPassword();


        if(!(name.equalsIgnoreCase(customer.getEmail()) && password.equalsIgnoreCase(customer.getPassword())))
            return new ResponseEntity<String>("Invalid credentials. Please check the username and password.", HttpStatus.UNAUTHORIZED);
        else {
            // Creating JWT using the user credentials.
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("usr", login.getUsername());
            claims.put("sub", "Authentication token");
            claims.put("iss", Iconstants.ISSUER);
            claims.put("rol", "Administrator, Developer");
            claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Iconstants.SECRET_KEY).compact();
            System.out.println("Returning the following token to the user= "+ jwttoken);
        }

        return new ResponseEntity<String>(jwttoken, HttpStatus.OK);
    }
}