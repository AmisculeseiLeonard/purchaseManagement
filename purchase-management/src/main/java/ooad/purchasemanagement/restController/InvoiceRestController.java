package ooad.purchasemanagement.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ooad.purchasemanagement.dao.Dao;
import ooad.purchasemanagement.exception.ResourceNotFoundException;
import ooad.purchasemanagement.model.Invoice;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {
	
	@Autowired
	@Qualifier("invoice")
	private Dao<Invoice> invoiceRepository;
	
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices(){
		return invoiceRepository.getAll();
	}
	
	@GetMapping("invoices/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id) {
		Invoice invoice = invoiceRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(invoice);
	}
	
	@PostMapping("/invoices")
	public void createInvoice(@RequestBody Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	@PutMapping("/invoices/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable int id,@RequestBody @Valid Invoice invoiceDetails) {
		Invoice invoice = invoiceRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice with id: " + id + " doesn't exist"));
		
		invoice.setId(invoiceDetails.getId());
		invoice.setDate(invoiceDetails.getDate());
		invoice.setPaymentMethod(invoiceDetails.getPaymentMethod());
		invoice.setInvoiceLines(invoiceDetails.getInvoiceLines());
		invoice.setSupplier(invoiceDetails.getSupplier());
		
		Invoice updatedEmployee = invoiceRepository.update(invoice);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInvoice(@PathVariable int id) {
		Invoice invoice = invoiceRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice with id: " + id + " doesn't exist"));
		
		invoiceRepository.delete(invoice);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
