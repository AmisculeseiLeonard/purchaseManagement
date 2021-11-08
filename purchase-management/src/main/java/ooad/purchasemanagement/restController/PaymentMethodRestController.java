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
import ooad.purchasemanagement.model.PaymentMethod;

@RestController
@RequestMapping("/api")
public class PaymentMethodRestController {
	
	@Autowired
	@Qualifier("payment_method")
	private Dao<PaymentMethod> paymentMethodRepository;
	
	@GetMapping("/payment-method")
	public List<PaymentMethod> getAllPaymentMethod(){
		return paymentMethodRepository.getAll();
	}
	
	@GetMapping("payment-method/{id}")
	public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable int id) {
		PaymentMethod paymentMethod = paymentMethodRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Payment method with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(paymentMethod);
	}

}
