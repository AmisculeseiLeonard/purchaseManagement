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

import ooad.purchasemanagement.model.Product;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	@Qualifier("product")
	private Dao<Product> productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.getAll();
	}
	
	@GetMapping("products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product employee = productRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping("/products")
	public void createProduct(@RequestBody Product employee) {
		productRepository.save(employee);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody @Valid Product productDetails) {
		Product product = productRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
		
		product.setProductCode(productDetails.getProductCode());
		product.setProductName(productDetails.getProductName());
		product.setUm(productDetails.getUm());
		
		
		Product updatedProduct = productRepository.update(product);
		return ResponseEntity.ok(updatedProduct);
		
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id) {
		Product product = productRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
