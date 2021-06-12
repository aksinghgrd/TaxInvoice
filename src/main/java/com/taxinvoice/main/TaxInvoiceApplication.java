package com.taxinvoice.main;

import com.taxinvoice.dto.TaxReportInput;
import com.taxinvoice.service.TaxInvoiceService;
import com.taxinvoice.service.TaxInvoiceServiceImpl;
import com.taxinvoice.util.ArgumentValidator;

public class TaxInvoiceApplication {
	public static void main(String[] args) {
		TaxReportInput input = ArgumentValidator.ValidateArgument(args);
		
		TaxInvoiceService service = new TaxInvoiceServiceImpl();
		System.out.println(service.getTaxReport(input));
		
	}

}
