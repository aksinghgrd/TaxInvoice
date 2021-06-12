package com.taxinvoice.service;

import com.taxinvoice.dto.TaxReportInput;
import com.taxinvoice.repository.InvoiceRepository;

public interface TaxInvoiceService {

	InvoiceRepository invoice_repository = new InvoiceRepository();
	
	public String getTaxReport(TaxReportInput input);
	
}