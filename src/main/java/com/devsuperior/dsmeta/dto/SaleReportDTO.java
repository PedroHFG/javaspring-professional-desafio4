package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public class SaleReportDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private Seller seller;

    public SaleReportDTO() {

    }

    public SaleReportDTO(Long id, LocalDate date, Double amount, Seller seller) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.seller = seller;
    }

    public SaleReportDTO(Sale entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.amount = entity.getAmount();
        this.seller = entity.getSeller();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Seller getSeller() {
        return seller;
    }
}
