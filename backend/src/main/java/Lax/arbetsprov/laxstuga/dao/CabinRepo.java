package Lax.arbetsprov.laxstuga.dao;


import Lax.arbetsprov.laxstuga.entitys.Cabins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CabinRepo extends JpaRepository<Cabins, Long> {
    List<Cabins> findByType(String type);
    Cabins deleteById(long id);

    @Query("select c from Cabins c where c.type= :type AND c.booked= :isbooked")
    List<Cabins> findWhere(String type, Boolean isbooked);
}
