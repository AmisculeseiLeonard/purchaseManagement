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
import ooad.purchasemanagement.model.OrderDoc;

@RestController
@RequestMapping("/api")
public class OrderDocRestController {
	
	@Autowired
	@Qualifier("order")
	private Dao<OrderDoc> orderRepository;
	
	@GetMapping("/orders")
	public List<OrderDoc> getAllOrders(){
		return orderRepository.getAll();
	}
	
	@GetMapping("orders/{id}")
	public ResponseEntity<OrderDoc> getOrderById(@PathVariable int id) {
		OrderDoc order = orderRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(order);
	}
	
	@PostMapping("/orders")
	public void createOrder(@RequestBody OrderDoc order) {
		orderRepository.save(order);
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<OrderDoc> updateOrder(@PathVariable int id,@RequestBody @Valid OrderDoc orderDocDetails) {
		OrderDoc order = orderRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " doesn't exist"));
		
		order.setId(orderDocDetails.getId());
		order.setDate(orderDocDetails.getDate());
		order.setInvoiceGenerated(orderDocDetails.isInvoiceGenerated());
		order.setSupplier(orderDocDetails.getSupplier());
		order.setOrderLines(orderDocDetails.getOrderLines());
		
		OrderDoc updatedOrder = orderRepository.update(order);
		return ResponseEntity.ok(updatedOrder);
		
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable int id) {
		OrderDoc order = orderRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " doesn't exist"));
		
		orderRepository.delete(order);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		return ResponseEntity.ok(response);
	}

}
