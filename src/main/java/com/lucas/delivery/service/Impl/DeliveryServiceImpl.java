package com.lucas.delivery.service.Impl;

import com.lucas.delivery.model.Delivery;
import com.lucas.delivery.repository.DeliveryRepository;
import com.lucas.delivery.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public void updateStatus(Long id, Delivery.Status status) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        delivery.setStatus(status);
        if (status == Delivery.Status.ENTREGUE) {
            delivery.setDeliveredIn(LocalDateTime.now());
        }
        deliveryRepository.save(delivery);
    }


}
