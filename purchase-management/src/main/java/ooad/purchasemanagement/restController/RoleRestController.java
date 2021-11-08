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
import ooad.purchasemanagement.model.Role;

@RestController
@RequestMapping("/api")
public class RoleRestController {
	
	@Autowired
	@Qualifier("role")
	private Dao<Role> roleRepository;
	
	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		return roleRepository.getAll();
	}
	
	@GetMapping("roles/{id}")
	public ResponseEntity<Role> getEmployeeById(@PathVariable int id) {
		Role role = roleRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Role with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(role);
	}
	
}
