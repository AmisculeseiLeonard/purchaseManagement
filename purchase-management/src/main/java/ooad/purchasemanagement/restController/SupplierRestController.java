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
import ooad.purchasemanagement.model.Supplier;

@RestController
@RequestMapping("/api")
public class SupplierRestController {
	
	@Autowired
	@Qualifier("supplier")
	private Dao<Supplier> supplierRepository;
	
	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers(){
		return supplierRepository.getAll();
	}
	
	@GetMapping("suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
		Supplier supplier = supplierRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Supplier with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(supplier);
	}
	
	@PostMapping("/suppliers")
	public void createSupplier(@RequestBody Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable int id,@RequestBody @Valid Supplier supplierDetails) {
		Supplier supplier = supplierRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Supplier with id: " + id + " doesn't exist"));
		
		supplier.setId(supplierDetails.getId());
		supplier.setName(supplierDetails.getName());
		supplier.setAddress(supplierDetails.getAddress());
		supplier.setCui(supplierDetails.getCui());
		supplier.setAgents(supplierDetails.getAgents());
		
		
		Supplier updatedSupplier = supplierRepository.update(supplier);
		return ResponseEntity.ok(updatedSupplier);
		
	}
	
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable int id) {
		Supplier supplier = supplierRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Supplier with id: " + id + " doesn't exist"));
		
		supplierRepository.delete(supplier);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
