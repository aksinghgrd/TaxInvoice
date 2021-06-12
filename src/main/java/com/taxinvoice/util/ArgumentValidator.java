package com.taxinvoice.util;

import java.io.File;

import com.taxinvoice.dto.TaxReportInput;

public class ArgumentValidator {

	public static TaxReportInput ValidateArgument(String[] args){
		
		if(args.length < 3) {
			throw new IllegalArgumentException("Three args are required!!!!!!");
		}
		
		TaxType taxType;
		try {
			taxType = TaxType.valueOf(args[0].toUpperCase());
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Tax type not found!!!!!!");
		}
			
		long custId;

		try {
			custId = Long.parseLong(args[1]);
		}catch (Exception e) {
			throw new IllegalArgumentException("Invalid Customer ID");
		}

		File file = new File(args[2]);
		if(!file.exists()) {
			throw new IllegalArgumentException("Tax Invoice file does not exists!!!!!!");
		}
	

		return new TaxReportInput(taxType, custId, args[2]);
	}

}
