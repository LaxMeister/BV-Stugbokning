package Lax.arbetsprov.laxstuga.dao;


import Lax.arbetsprov.laxstuga.entitys.Cabins;
import Lax.arbetsprov.laxstuga.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);

}
