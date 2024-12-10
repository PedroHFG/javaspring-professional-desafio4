package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.projections.SaleReportProjection;
import com.devsuperior.dsmeta.projections.SaleSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true,
    value = "SELECT tb_sales.id, tb_sales.date, tb_sales.amount, tb_seller.name AS seller FROM TB_SALES " +
            "INNER JOIN tb_seller ON tb_sales.seller_id=tb_seller.id " +
            "WHERE UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "AND tb_sales.date BETWEEN :minDate AND :maxDate",
    countQuery = "SELECT COUNT(*) FROM TB_SALES " +
                 "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
                 "WHERE UPPER(tb_seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
                 "AND tb_sales.date BETWEEN :minDate AND :maxDate")
    Page<SaleReportProjection> getReport(String name, String minDate, String maxDate, Pageable pageable);

    @Query(nativeQuery = true,
    value = "SELECT tb_seller.name AS sellerName, SUM(tb_sales.amount) AS total FROM TB_SALES " +
            "INNER JOIN tb_seller ON tb_sales.seller_id=tb_seller.id " +
            "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY sellerName")
    List<SaleSummaryProjection> getSummary(String minDate, String maxDate);
}
