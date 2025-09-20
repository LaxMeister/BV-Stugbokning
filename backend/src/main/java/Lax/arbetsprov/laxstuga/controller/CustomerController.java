package Lax.arbetsprov.laxstuga.controller;


import Lax.arbetsprov.laxstuga.entitys.Customer;
import Lax.arbetsprov.laxstuga.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class CustomerController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    CustomerService customerService;

    // Listar alla kunder
    @Operation(summary = "Visa alla kunder", description = "Listar alla kunder som finns i databasen.")
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.customers();
    }

    // Listar specifik kund
    @Operation(summary = "Visa Specifik kund", description = "Visar specifik kund <br> Skriv ID på kunden du vill se.")
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.findCustomer(id);
    }

//    @GetMapping("/currentUser")
//    public Customer getCurrentUser (HttpServletRequest request){
//        Principal principal = request.getUserPrincipal();
//        if (principal == null) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
//        }
//        String userName = principal.getName();
//        return customerService.findCurrentUser(userName);
//    }
}