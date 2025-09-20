package Lax.arbetsprov.laxstuga.service;


import Lax.arbetsprov.laxstuga.dao.CabinRepo;
import Lax.arbetsprov.laxstuga.dao.CustomerRepo;
import Lax.arbetsprov.laxstuga.dao.OrderRepo;
import Lax.arbetsprov.laxstuga.entitys.Cabins;
import Lax.arbetsprov.laxstuga.entitys.Customer;
import Lax.arbetsprov.laxstuga.entitys.Orders;
import Lax.arbetsprov.laxstuga.utility.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CabinRepo cabinRepo;

    public List<Orders> myOrders() {
        return orderRepo.findAll();
    }

    public List<Orders> oneCustomersOrders(long customerId) {
        return orderRepo.findAllByCustomerId(customerId);
    }

    public Orders orderCabin(String number, String date){
        String customerString = number.substring(0,1);
        String cabinString = number.substring(1,2);
        long customerId = Long.parseLong(customerString);
        long cabinId = Long.parseLong(cabinString);
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer ID: " + customerId + "not found"));
        Cabins cabin = cabinRepo.findById(cabinId).orElseThrow(() -> new ResourceNotFoundException("Cabin ID: "+ cabinId +" not found"));
        String rentDate = date.substring(0,10);
        String returnDate = date.substring(10,20);
        int rentInt = customer.getRentTimes();
        rentInt++;

        Orders newOrder = new Orders(customer.getFirstname(), customer.getLastname(), customer.getId(), cabin.getName() , cabin.getId(), rentDate,returnDate);
        cabin.setBooked(true);
        newOrder.setBooked(true);
        customer.setRentTimes(rentInt);
        customerRepo.save(customer);
        orderRepo.findAll().add(newOrder);
        orderRepo.save(newOrder);
        return newOrder;
    }

    public Orders updateOrder(long id){
        Orders order = orderRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order ID: " + id + " not found"));
        Cabins cabin = cabinRepo.findById(order.getCabinId()).orElseThrow(() -> new ResourceNotFoundException("Cabin ID: " + order.getCabinId() + " not found"));
        cabin.setBooked(false);
        order.setBooked(false);
        cabinRepo.save(cabin);
        orderRepo.save(order);
        return order;

    }

    public Orders findOrderById(long id) {
        return  orderRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order ID: " + id + " not found"));
    }

}
