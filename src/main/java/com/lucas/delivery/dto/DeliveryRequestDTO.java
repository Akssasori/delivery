package com.lucas.delivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DeliveryRequestDTO(
        @NotBlank(message = "O setor é obrigatório")  String sector,
        @NotBlank(message = "A empresa é obrigatória") String enterprise,
        @NotNull(message = "A data é obrigatória") LocalDate previewData,
        String recipientName,
        String deliveryCode
){

    public DeliveryRequestDTO {
        sector = sector.toUpperCase();
        enterprise = enterprise.toUpperCase();
        if (recipientName != null) recipientName = recipientName.toUpperCase();
        if (deliveryCode != null) deliveryCode = deliveryCode.toUpperCase();
    }
}
