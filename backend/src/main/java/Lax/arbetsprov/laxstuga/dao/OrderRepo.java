package Lax.arbetsprov.laxstuga.dao;


import Lax.arbetsprov.laxstuga.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders, Long> {
    Orders findByCabinId(long id);
    List<Orders> findAllByCustomerId(long customerId);


}
