package com.lucas.delivery.service;

import com.lucas.delivery.dto.DeliveryRequestDTO;
import com.lucas.delivery.enums.StatusEnum;
import com.lucas.delivery.model.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryService {

    Page<Delivery> findAll(Pageable pageable);
    Delivery save(DeliveryRequestDTO delivery);
    void updateStatus(Long id, StatusEnum status);
}