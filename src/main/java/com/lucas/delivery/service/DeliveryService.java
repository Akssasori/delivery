package com.lucas.delivery.service;

import com.lucas.delivery.model.Delivery;

import java.util.List;

public interface DeliveryService {

    List<Delivery> findAll();
    Delivery save(Delivery delivery);
    void updateStatus(Long id, Delivery.Status status);
}