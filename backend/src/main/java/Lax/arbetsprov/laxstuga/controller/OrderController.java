package Lax.arbetsprov.laxstuga.controller;


import Lax.arbetsprov.laxstuga.entitys.Orders;
import Lax.arbetsprov.laxstuga.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Visar alla kunders nuvarande och tidigare ordrar.
    @Operation(summary = "Visa alla ordrar", description = "Visar alla ordrar som har gjorts")
    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return orderService.myOrders();
    }

    // Visar en specifik kunds alla tidigare och nuvarande ordrar.
    @Operation(summary = "Visa en kunds alla ordrar", description = "Visar en specifik kunds alla tidigare och nuvarande ordrar. <br> Skriv ID på kunden du vill se.")
    @GetMapping("/customerorders/{customerId}")
    public List<Orders> getCustomerOrders(@PathVariable long customerId){
        return orderService.oneCustomersOrders(customerId);
    }

    /*
    Här sker bokningen av stuga.
    För att testa detta i postman eller annat verktyg.
    Skriver man 2st sifror i pathen likt detta sätt (/ordercabin/14).
    första siffran är id på kunden andra siffran är nummret på stugan.

    I bodyn på requesten skriver man ett från och till datum på detta sätt (2025-09-202025-09-21)
    bodyn ska vara Raw - text dvs plain text.
    */
    @PostMapping(
            value = "/ordercabin/{number}",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Boka en stuga", description = "Här sker bokning av en stuga. <br>Skriv in 2 siffor i fältet number tillexempel 12. <br> Första siffran är ID på kund och andra siffran är ID på stugan. <br> I Request body skriver du två datum på detta sätt (2025-09-202025-09-21). <br> Ena datumet är ett från datum och det andra är ett till datum")
    public Orders orderCabin(@PathVariable String number, @RequestBody String date ) {
        return orderService.orderCabin(number, date);
    }

    // Sätter en bool på stugan som är uthyrd till false.
    @Operation(summary = "Uppdatera bokning", description = "Uppdatera uthyrnings statusen på en stuga. <br> Är stugan uthyrd så är booked true annars är den false om ledig. <br> Number är order ID.")
    @PutMapping("/updateorder/{number}")
    public Orders updateOrders(@PathVariable String number){
        return orderService.updateOrder(Long.parseLong(number));
    }

    // Visar en specifik order
    @Operation(summary = "Visa specifik order", description = "Visar en specifik order. <br> Skriv ID på ordern du vill se")
    @GetMapping("/orders/{id}")
    public Orders getOrder(@PathVariable long id){
        return orderService.findOrderById(id);
    }

}
