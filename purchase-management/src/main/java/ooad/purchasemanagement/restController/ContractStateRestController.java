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
import ooad.purchasemanagement.model.AbstractContractState;


@RestController
@RequestMapping("/api")
public class ContractStateRestController {
	
	@Autowired
	@Qualifier("contract_state")
	private Dao<AbstractContractState> contractStateRepository;
	
	@GetMapping("/contract-states")
	public List<AbstractContractState> getAllContractStates(){
		return contractStateRepository.getAll();
	}
	
	@GetMapping("contract-states/{id}")
	public ResponseEntity<AbstractContractState> getContractStateById(@PathVariable int id) {
		AbstractContractState contractState = contractStateRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Contract state with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(contractState);
	}
}
