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
import ooad.purchasemanagement.model.Employee;
import ooad.purchasemanagement.model.OrderLine;

@RestController
@RequestMapping("/api")
public class OrderLineRestController {
	
	@Autowired
	@Qualifier("orderLine")
	private Dao<OrderLine> orderLineRepository;
	 
	@GetMapping("/orderLines")
	public List<OrderLine> getAllOrderLines() {
		return orderLineRepository.getAll();
	}
	
	@GetMapping("/orderLines/{id}")
	public ResponseEntity<OrderLine> getOrderLineById(@PathVariable int id) {
		OrderLine orderLine = orderLineRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Order Line with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(orderLine);
	}
	
	@PostMapping("/orderLines")
	public void createOrderLine(@RequestBody @Valid OrderLine orderLine) {
		orderLineRepository.save(orderLine);
	}
	
	@PutMapping("/orderLines/{id}")
	public ResponseEntity<OrderLine> updateOrderLine(@PathVariable int id, @RequestBody @Valid OrderLine orderLineDetails) {
		OrderLine orderLine = orderLineRepository.get(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order Line with id: " + id + " doesn't exist"));
		
		orderLine.setId(orderLineDetails.getId());
		orderLine.setCantitate(orderLineDetails.getCantitate());
		orderLine.setPret(orderLineDetails.getPret());
		orderLine.setOrder(orderLineDetails.getOrder());
		orderLine.setProduct(orderLineDetails.getProduct());
		
		OrderLine updatedOrderLine = orderLineRepository.update(orderLine);
		return ResponseEntity.ok(updatedOrderLine);
				
	}
	
	@DeleteMapping("/orderLines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrderLine(@PathVariable int id) {
		OrderLine orderLine = orderLineRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Order Line with id: " + id + " doesn't exist"));
		
		orderLineRepository.delete(orderLine);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	

}
