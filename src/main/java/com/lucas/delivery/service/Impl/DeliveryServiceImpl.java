package com.lucas.delivery.service.Impl;

import com.lucas.delivery.dto.DeliveryRequestDTO;
import com.lucas.delivery.enums.StatusEnum;
import com.lucas.delivery.model.Delivery;
import com.lucas.delivery.repository.DeliveryRepository;
import com.lucas.delivery.service.DeliveryService;
import org.springframework.beans.BeanUtils;
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
    public Delivery save(DeliveryRequestDTO delivery) {
        return deliveryRepository.save(convertDtoToModel(delivery));
    }

    private Delivery convertDtoToModel(DeliveryRequestDTO delivery) {
        Delivery deliveryModel = new Delivery();
        BeanUtils.copyProperties(delivery, deliveryModel);
        return deliveryModel;
    }

    @Override
    public void updateStatus(Long id, StatusEnum status) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        delivery.setStatus(status);
        if (status == StatusEnum.ENTREGUE) {
            delivery.setDeliveredIn(LocalDateTime.now());
        }
        deliveryRepository.save(delivery);
    }


}
