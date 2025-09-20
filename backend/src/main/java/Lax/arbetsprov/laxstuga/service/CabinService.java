package Lax.arbetsprov.laxstuga.service;

import Lax.arbetsprov.laxstuga.dao.CabinRepo;

import Lax.arbetsprov.laxstuga.dao.OrderRepo;
import Lax.arbetsprov.laxstuga.entitys.Cabins;
import Lax.arbetsprov.laxstuga.entitys.Orders;
import Lax.arbetsprov.laxstuga.utility.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {
    @Autowired
    CabinRepo cabinRepo;

    @Autowired
    OrderRepo orderRepo;

    public List<Cabins> cabins() {
        return cabinRepo.findAll();
    }

    public Cabins getCabinById(Long id) {
        return cabinRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cabin ID: " + id + " not found"));
    }

    public List<Cabins> getCabinsByType(String type) {
        List<Cabins> cabins = cabinRepo.findByType(type.substring(0, 1).toUpperCase() + type.substring(1));
        if(cabins.isEmpty()){
            throw new ResourceNotFoundException("No cabins was found with that size");
        }
        return cabins ;
    }
    public Cabins addCabin(Cabins cabins) {
        cabinRepo.findAll().add(cabins);
        cabinRepo.save(cabins);
        return cabins;
    }

    public Cabins updateCabin(Cabins cabin) {
        Cabins updatedCabin = cabinRepo.findById(cabin.getId()).orElseThrow(() -> new ResourceNotFoundException("Cabin ID: " + cabin.getId() + " not found"));
        updatedCabin.setId(cabin.getId());
        updatedCabin.setPrice(cabin.getPrice());
        updatedCabin.setName(cabin.getName());
        updatedCabin.setDate(cabin.getDate());
        updatedCabin.setBooked(cabin.isBooked());
        updatedCabin.setDetails(cabin.getDetails());
        updatedCabin.setType(cabin.getType());
        cabinRepo.save(updatedCabin);
        return updatedCabin;
    }

    public String deleteCabin(Cabins cabin) {
        Cabins cabinInfo = cabinRepo.findById(cabin.getId()).orElseThrow(() -> new ResourceNotFoundException("Cabin ID: " + cabin.getId() + " not found"));
        Cabins carDelete = cabinRepo.deleteById(cabin.getId());
        List<Cabins> newCabin = cabinRepo.findWhere(cabinInfo.getType(),false);
        if(cabinInfo.isBooked()){
            Orders order = orderRepo.findByCabinId(cabinInfo.getId());
            order.setCabin(newCabin.get(0).getName());
            order.setCabinId(newCabin.get(0).getId());
            newCabin.get(0).setBooked(true);
            orderRepo.save(order);
            cabinRepo.save(newCabin.get(0));
        }


        return cabinInfo.getName() + " " + " was deleted";
    }
}