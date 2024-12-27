package com.lucas.delivery.model;

import com.lucas.delivery.enums.StatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sector;
    private String enterprise;
    private LocalDate previewData;
    private LocalDateTime deliveredIn;
    private String recipientName;
    private String deliveryCode;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PENDENTE;

    public Delivery() {
    }

    public Delivery(Long id, String sector, String enterprise, LocalDate previewData, LocalDateTime deliveredIn,
                    StatusEnum status, String recipientName, String deliveryCode) {
        this.id = id;
        this.sector = sector;
        this.enterprise = enterprise;
        this.previewData = previewData;
        this.deliveredIn = deliveredIn;
        this.status = status;
        this.recipientName = recipientName;
        this.deliveryCode = deliveryCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public LocalDate getPreviewData() {
        return previewData;
    }

    public void setPreviewData(LocalDate previewData) {
        this.previewData = previewData;
    }

    public LocalDateTime getDeliveredIn() {
        return deliveredIn;
    }

    public void setDeliveredIn(LocalDateTime deliveredIn) {
        this.deliveredIn = deliveredIn;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", sector='" + sector + '\'' +
                ", enterprise='" + enterprise + '\'' +
                ", previewData=" + previewData +
                ", deliveredIn=" + deliveredIn +
                ", recipientName='" + recipientName + '\'' +
                ", deliveryCode='" + deliveryCode + '\'' +
                ", status=" + status +
                '}';
    }
}
