package com.lucas.delivery.model;

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

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDENTE;

    public Delivery() {
    }

    public Delivery(Long id, String sector, String enterprise, LocalDate previewData, LocalDateTime deliveredIn, Status status) {
        this.id = id;
        this.sector = sector;
        this.enterprise = enterprise;
        this.previewData = previewData;
        this.deliveredIn = deliveredIn;
        this.status = status;
    }

    public enum Status {
        PENDENTE, ENTREGUE
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", sector='" + sector + '\'' +
                ", enterprise='" + enterprise + '\'' +
                ", previewlData=" + previewData +
                ", deliveredIn=" + deliveredIn +
                ", status=" + status +
                '}';
    }
}
