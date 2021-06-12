package com.taxinvoice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.taxinvoice.dto.TaxReportInput;
import com.taxinvoice.repository.InvoiceRepository;
import com.taxinvoice.service.TaxInvoiceServiceImpl;
import com.taxinvoice.util.TaxType;


@RunWith(MockitoJUnitRunner.class)
public class TaxInvoiceServiceTest {
	
	
	@Mock
	InvoiceRepository repository;
	
	@Mock
	TaxInvoiceServiceImpl service;
	
	
	public static String path;
	

	@BeforeClass
	public static void setUpTest() {
		String resourceName = "taxinvoice-test.csv";
		ClassLoader classLoader = TaxInvoiceServiceTest.class.getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		path = file.getAbsolutePath();
	}
	
	@Test
	public void testRepository() {
		
		repository.getInvoiceReccords(Mockito.anyString());
		verify(repository).getInvoiceReccords(Mockito.anyString());
		verify(repository, times(1)).getInvoiceReccords(Mockito.anyString());
		
		when(repository.getInvoiceReccords(Mockito.anyString())).thenCallRealMethod();
		assertNull(repository.getInvoiceReccords(Mockito.anyString()));
		
		when(repository.getInvoiceReccords(path)).thenCallRealMethod();
		assertNotNull(repository.getInvoiceReccords(path));
		
		int count = repository.getInvoiceReccords(path).size();
		assertEquals(12, count);
		
	}
	
	
	@Test
	public void testTaxReport() {

		TaxType taxType = TaxType.GST;
		
		TaxReportInput in = Mockito.mock(TaxReportInput.class);
		
		service.getTaxReport(in);
		verify(service).getTaxReport(in);
		verify(service, times(1)).getTaxReport(in);
	
		TaxReportInput taxInput = new TaxReportInput(taxType, 123, path);
		
		when(service.getTaxReport(taxInput)).thenCallRealMethod();
		
		assertNotNull(service.getTaxReport(taxInput));
		
		String res = service.getTaxReport(taxInput);
		
		String expected = "For tax GST, customer 123 has declared $48.2";

		assertEquals(expected, res);
	
		
	}

}
