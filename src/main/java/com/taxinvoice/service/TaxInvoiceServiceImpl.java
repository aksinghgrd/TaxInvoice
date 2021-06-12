package com.taxinvoice.service;

import java.util.List;

import com.taxinvoice.dto.TaxInvoiceDto;
import com.taxinvoice.dto.TaxReportInput;

public class TaxInvoiceServiceImpl implements TaxInvoiceService {
	
	public static final double TAX_PERCENT = 10;
	
	public static final String RESULT_STR = "For tax %s, customer %s has declared $%s";
	

	@Override
	public String getTaxReport(TaxReportInput input) {
		List<TaxInvoiceDto> invoices = invoice_repository.getInvoiceReccords(input.getFilePath());
		
		double sum = invoices.stream()
				.filter(n -> n.getCustId() == input.getCustId() && n.getTaxType() == input.getTaxType())
				.mapToDouble(n -> n.getAmount()).sum();
		
		double tax = sum * TAX_PERCENT / 100;
		
		return String.format(RESULT_STR, input.getTaxType(), input.getCustId(), tax);
	}
	


}
