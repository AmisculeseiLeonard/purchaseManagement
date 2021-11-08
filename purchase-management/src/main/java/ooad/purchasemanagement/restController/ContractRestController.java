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
import ooad.purchasemanagement.model.Contract;


@RestController
@RequestMapping("/api")
public class ContractRestController {
	
	@Autowired
	@Qualifier("contract")
	private Dao<Contract> contractRepository;
	
	@GetMapping("/contracts")
	public List<Contract> getAllContracts(){
		return contractRepository.getAll();
	}
	
	@GetMapping("contracts/{id}")
	public ResponseEntity<Contract> getContractById(@PathVariable int id) {
		Contract contract = contractRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Contract with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(contract);
	}
	
	@PostMapping("/contracts")
	public void createContract(@RequestBody Contract contract) {
		contractRepository.save(contract);
	}
	
	@PutMapping("/contracts/{id}")
	public ResponseEntity<Contract> updateContract(@PathVariable int id,@RequestBody @Valid Contract contractDetails) {
		Contract contract = contractRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Contract with id: " + id + " doesn't exist"));
		
		contract.setId(contractDetails.getId());
		contract.setContractState(contractDetails.getContractState());
		contract.setContractType(contractDetails.getContractType());
		contract.setDate(contractDetails.getDate());
		contract.setDescription(contractDetails.getDescription());
		contract.setEndDate(contractDetails.getEndDate());
		contract.setSupplier(contractDetails.getSupplier());
		
		
		Contract updatedContract= contractRepository.update(contract);
		return ResponseEntity.ok(updatedContract);
		
	}
	
	@DeleteMapping("/contracts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContract(@PathVariable int id) {
		Contract contract = contractRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Contract with id: " + id + " doesn't exist"));
		
		contractRepository.delete(contract);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	

}
