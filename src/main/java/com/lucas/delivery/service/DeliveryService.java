package com.lucas.delivery.service;

import com.lucas.delivery.dto.DeliveryRequestDTO;
import com.lucas.delivery.enums.StatusEnum;
import com.lucas.delivery.model.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> findAll();
    Delivery save(DeliveryRequestDTO delivery);
    void updateStatus(Long id, StatusEnum status);
}