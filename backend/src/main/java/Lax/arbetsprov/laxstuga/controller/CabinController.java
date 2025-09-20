package Lax.arbetsprov.laxstuga.controller;


import Lax.arbetsprov.laxstuga.entitys.Cabins;
import Lax.arbetsprov.laxstuga.service.CabinService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:8080","http://localhost:8080","http://localhost:8082","http://localhost:5002"}, allowCredentials = "true")
public class CabinController {

    @Autowired
    CabinService cabinService;

    // Listar alla stugor
    @Operation(summary = "Visa alla stugor", description = "Listar alla stugor som finns i databasen.")
    @GetMapping("/cabins")
    public List<Cabins> cabins(){
        return cabinService.cabins();
    }

    // Listar en specifik stuga
    @Operation(summary = "Visa en specifik stuga", description = "Visar specifik stuga <br> Skriv ID på stugan du vill se")
    @GetMapping("/cabin/{id}")
    public Cabins getCabin(@PathVariable long id){
        return cabinService.getCabinById(id);
    }
    // Listar stugor efter storlek på stugan
    @Operation(summary = "Visar stugor efter storlek", description = "Visar stugor efter storlek <br> Skriv skriv storlek i request body <br> Välj mellan storlekarna Liten, Mellan, Stor")
    @GetMapping("/cabinstype/{type}")
    public List<Cabins> getCabinsByType(@PathVariable String type){
        return cabinService.getCabinsByType(type);
    }

    // Lägger till en ny stuga
    @Operation(summary = "Lägg till ny stuga", description = "Lägger till ny stuga i databasen <br> Request bodyn kräver ett stug objekt se exempel nedan")
    @PostMapping("/addcabins")
    public Cabins addCabin(@RequestBody Cabins cabin){
        return cabinService.addCabin(cabin);
    }

    // Tar bort en stuga från databasen. (Inte att rekommendera men finns där "just in case")
    @Operation(summary = "Ta bort en stuga", description = "OBS detta rekommenderas inte, denna finns bara ´´just in case´´ <br> Request bodyn kräver ett stug objekt se exempel nedan ")
    @DeleteMapping("/deletecabin")
    public String deleteCabin(@RequestBody Cabins cabin){
        return cabinService.deleteCabin(cabin);
    }

    // Uppdaterar information på befintlig stuga
    @Operation(summary = "Uppdatera en stuga", description = "Uppdaterar en befintlig stuga <br> Request bodyn kräver ett stug objekt se exempel nedan ")
    @PutMapping("/updatecabin")
    public Cabins updateCabin(@RequestBody Cabins cabin){
        return cabinService.updateCabin(cabin);
    }
}
