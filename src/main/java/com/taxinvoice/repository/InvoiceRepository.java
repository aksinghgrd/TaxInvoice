package com.taxinvoice.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.taxinvoice.dto.TaxInvoiceDto;

public class InvoiceRepository {
	
public List<TaxInvoiceDto> getInvoiceReccords(String file) {
		
		List<TaxInvoiceDto> beans = null;
		try {
			beans = new CsvToBeanBuilder<TaxInvoiceDto>(new FileReader(file))
			        .withType(TaxInvoiceDto.class)
			        .build()
			        .parse();
			
		} catch (IllegalStateException | FileNotFoundException e) {
			return null;
		}
        return beans;

	}

}
