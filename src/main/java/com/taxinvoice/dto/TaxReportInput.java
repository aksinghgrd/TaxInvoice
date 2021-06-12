package com.taxinvoice.dto;

import com.taxinvoice.util.TaxType;

public class TaxReportInput {
	private TaxType taxType;
	private long custId;
	private String filePath;

	public TaxReportInput(TaxType taxType, long custId, String filePath) {
		this.taxType = taxType;
		this.custId = custId;
		this.filePath = filePath;
	}

	public TaxType getTaxType() {
		return taxType;
	}
	
	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}
	public long getCustId() {
		return custId;
	}
	
	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
