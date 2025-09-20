package Lax.arbetsprov.laxstuga.controller;


import Lax.arbetsprov.laxstuga.entitys.EmailRequest;
import Lax.arbetsprov.laxstuga.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class EmailController {
    @Autowired
    EmailService emailService;

    // Skickar bekräftelse mail
    @Operation(summary = "Skicka mail", description = "Skicka ett mail <br> Request bodyn kräver ett mail objekt se exempel nedan")
    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}
