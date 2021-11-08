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

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	@Qualifier("employee")
	private Dao<Employee> employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAll();
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " doesn't exist"));
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping("/employees")
	public void createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody @Valid Employee employeeDetails) {
		Employee employee = employeeRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " doesn't exist"));
		
		employee.setId(employeeDetails.getId());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setBirthDate(employeeDetails.getBirthDate());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		employee.setRole(employeeDetails.getRole());
		
		Employee updatedEmployee = employeeRepository.update(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id) {
		Employee employee = employeeRepository.get(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " doesn't exist"));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
