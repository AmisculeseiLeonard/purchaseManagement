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
import ooad.purchasemanagement.model.Agent;

@RestController
@RequestMapping("/api")
public class AgentRestController {
	
	@Autowired
	@Qualifier("agent")
	private Dao<Agent> agentRepository;
	
	@GetMapping("/agents")
	public List<Agent> getAllAgents(){
		return agentRepository.getAll();
	}
	
	@GetMapping("agents/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable int id) {
		Agent agent = agentRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Agent with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(agent);
	}
	
	@PostMapping("/agents")
	public void createAgent(@RequestBody Agent agent) {
		agentRepository.save(agent);
	}
	
	@PutMapping("/agents/{id}")
	public ResponseEntity<Agent> updateAgent(@PathVariable int id,@RequestBody @Valid Agent agentDetails) {
		Agent agent = agentRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Agent with id: " + id + " doesn't exist"));
		
		agent.setId(agentDetails.getId());
		agent.setFirstName(agentDetails.getFirstName());
		agent.setLastName(agentDetails.getLastName());
		agent.setBirthDate(agentDetails.getBirthDate());
		agent.setEmail(agentDetails.getEmail());
		agent.setPhoneNumber(agentDetails.getPhoneNumber());
		agent.setRole(agentDetails.getRole());
		
		Agent updatedAgent = agentRepository.update(agent);
		return ResponseEntity.ok(updatedAgent);
		
	}
	
	@DeleteMapping("/agents/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAgent(@PathVariable int id) {
		Agent agent = agentRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Agent with id: " + id + " doesn't exist"));
		
		agentRepository.delete(agent);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
