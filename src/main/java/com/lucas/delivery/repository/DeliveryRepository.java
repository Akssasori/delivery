package com.lucas.delivery.repository;

import com.lucas.delivery.model.Delivery;
import org.springframework.data.repository.ListCrudRepository;

public interface DeliveryRepository extends ListCrudRepository<Delivery, Long> {
}
