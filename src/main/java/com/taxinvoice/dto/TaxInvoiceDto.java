package com.taxinvoice.dto;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import com.taxinvoice.util.TaxType;

public class TaxInvoiceDto {

	@CsvBindByPosition(position = 0)
	private long custId;
	
	@CsvBindByPosition(position = 1)
	private String invoiceNumber;
	 
	@CsvDate(value = "yyyy-MM-dd\'T\'hh:mm:ss")
	@CsvBindByPosition(position = 2)
	private Date date;
	 
	@CsvBindByPosition(position = 3)
	private double amount;
	 
	@CsvBindByPosition(position = 4)
	private String taxType;
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TaxType getTaxType() {
		return TaxType.valueOf(taxType.trim());
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	
}
