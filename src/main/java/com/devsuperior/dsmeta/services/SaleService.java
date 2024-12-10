package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.projections.SaleReportProjection;
import com.devsuperior.dsmeta.projections.SaleSummaryProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> getReport(String name, String minDate, String maxDate, Pageable pageable) {

		String[] datesArray = processDateRange(minDate, maxDate);
		String minDateStr = datesArray[0];
		String maxDateStr = datesArray[1];

		Page<SaleReportProjection> list = repository.getReport(name, minDateStr, maxDateStr, pageable);
		return list.map(x -> new SaleReportDTO(x));
	}

	public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {
		String[] datesArray = processDateRange(minDate, maxDate);
		String minDateStr = datesArray[0];
		String maxDateStr = datesArray[1];

		List<SaleSummaryProjection> list = repository.getSummary(minDateStr, maxDateStr);
		List<SaleSummaryDTO> result = list.stream().map(x -> new SaleSummaryDTO(x)).collect(Collectors.toList());
		return result;
	}

	public static String[] processDateRange(String minDate, String maxDate) {
        // Formatter para formatar as datas no formato "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Instanciar a data máxima
        LocalDate max = maxDate.isEmpty()
                        ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
                        : LocalDate.parse(maxDate, formatter);

        // Instanciar a data mínima
        LocalDate min = minDate.isEmpty()
                        ? max.minusYears(1L)
                        : LocalDate.parse(minDate, formatter);

        // Retornar as datas formatadas como strings
        return new String[]{min.format(formatter), max.format(formatter)};
    }
}
