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
import ooad.purchasemanagement.model.InvoiceLine;

@RestController
@RequestMapping("/api")
public class InvoiceLineRestController {
	
	@Autowired
	@Qualifier("invoice_line")
	private Dao<InvoiceLine> invoiceLineRepository;
	
	@GetMapping("/invoice-lines")
	public List<InvoiceLine> getAllInvoiceLines(){
		return invoiceLineRepository.getAll();
	}
	
	@GetMapping("invoice-lines/{id}")
	public ResponseEntity<InvoiceLine> getInvoiceLineById(@PathVariable int id) {
		InvoiceLine invoiceLine = invoiceLineRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice Line with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(invoiceLine);
	}
	
	@PostMapping("/invoice-lines")
	public void createInvoiceLine(@RequestBody InvoiceLine invoice) {
		invoiceLineRepository.save(invoice);
	}
	
	@PutMapping("/invoice-lines/{id}")
	public ResponseEntity<InvoiceLine> updateInvoice(@PathVariable int id,@RequestBody @Valid InvoiceLine invoiceLineDetails) {
		InvoiceLine invoiceLine = invoiceLineRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice Line with id: " + id + " doesn't exist"));
		
		invoiceLine.setId(invoiceLineDetails.getId());
		invoiceLine.setCantitate(invoiceLineDetails.getCantitate());
		invoiceLine.setPret(invoiceLineDetails.getPret());
		invoiceLine.setProduct(invoiceLineDetails.getProduct());
		invoiceLine.setInvoice(invoiceLineDetails.getInvoice());
		
		
		InvoiceLine updatedEmployee = invoiceLineRepository.update(invoiceLine);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("/invoice-lines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInvoice(@PathVariable int id) {
		InvoiceLine invoiceLine = invoiceLineRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Invoice Line with id: " + id + " doesn't exist"));
		
		invoiceLineRepository.delete(invoiceLine);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
