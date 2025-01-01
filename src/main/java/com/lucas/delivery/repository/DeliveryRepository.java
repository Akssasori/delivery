package com.lucas.delivery.repository;

import com.lucas.delivery.model.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface DeliveryRepository extends ListCrudRepository<Delivery, Long> {

    Page<Delivery> findAll(Pageable pageable);
}
