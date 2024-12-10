package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSummaryProjection;

public class SaleSummaryDTO {

    private String sellerName;
    private Double total;

    public SaleSummaryDTO() {

    }

    public SaleSummaryDTO(String seller, Double amount) {
        this.sellerName = seller;
        this.total = amount;
    }

    public SaleSummaryDTO(SaleSummaryProjection projection) {
        this.sellerName = projection.getSellerName();
        this.total = projection.getTotal();
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }

}
