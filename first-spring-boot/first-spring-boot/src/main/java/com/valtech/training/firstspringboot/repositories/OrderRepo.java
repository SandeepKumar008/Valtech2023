package com.valtech.training.firstspringboot.repositories;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.valtech.training.firstspringboot.entities.Order;
 
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	
	
	
 
}
 