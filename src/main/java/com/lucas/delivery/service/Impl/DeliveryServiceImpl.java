package com.lucas.delivery.service.Impl;

import com.lucas.delivery.dto.DeliveryRequestDTO;
import com.lucas.delivery.enums.StatusEnum;
import com.lucas.delivery.model.Delivery;
import com.lucas.delivery.repository.DeliveryRepository;
import com.lucas.delivery.service.DeliveryService;
import com.lucas.delivery.util.DateTimeConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Delivery> findAll(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
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
        delivery.setDeliveredIn(DateTimeConvert.nowLocalDateTimeBrazil());
        if (status == StatusEnum.ENTREGUE) {
            delivery.setDeliveredIn(LocalDateTime.now());
        }

        if (status == StatusEnum.PENDENTE){
            delivery.setDeliveredIn(null);
        }
        deliveryRepository.save(delivery);
    }

}
