package ooad.purchasemanagement.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ooad.purchasemanagement.dao.Dao;
import ooad.purchasemanagement.exception.ResourceNotFoundException;
import ooad.purchasemanagement.model.AbstractContractType;

@RestController
@RequestMapping("/api")
public class ContractTypeRestController {
	
	@Autowired
	@Qualifier("contract_type")
	private Dao<AbstractContractType> contractTypeRepository;
	
	@GetMapping("/contract-types")
	public List<AbstractContractType> getAllContractTypes(){
		return contractTypeRepository.getAll();
	}
	
	@GetMapping("contract-types/{id}")
	public ResponseEntity<AbstractContractType> getContractTypeById(@PathVariable int id) {
		AbstractContractType contractType= contractTypeRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Contract type with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(contractType);
	}

}
