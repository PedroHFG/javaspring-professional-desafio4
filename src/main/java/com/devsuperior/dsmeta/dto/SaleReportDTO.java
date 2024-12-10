package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SaleReportProjection;

import java.time.LocalDate;

public class SaleReportDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String seller;

    public SaleReportDTO() {

    }

    public SaleReportDTO(Long id, LocalDate date, Double amount, String seller) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.seller = seller;
    }

    public SaleReportDTO(SaleReportProjection projection) {
        this.id = projection.getId();
        this.date = projection.getDate();
        this.amount = projection.getAmount();
        this.seller = projection.getSeller();
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

    public String getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "SaleReportDTO{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", seller=" + seller +
                '}';
    }
}
