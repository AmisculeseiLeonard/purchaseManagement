package ooad.purchasemanagement.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ooad.purchasemanagement.model.Employee;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeDaoTest {
	
	@Autowired
	@Qualifier("employee")
	Dao<Employee> employeeDao;

	@Test
	@Rollback(value = false)
	public void saveEmployee() {
		
		Employee employee =
				new Employee("Leonard", "Amisculesei", null, "ssds", "asdasd@gmail.com", null);
		
		employeeDao.save(employee);
		
	}
	
	@Test
	@Rollback(value = false)
	public void getAllEmployees() {
		employeeDao.getAll();
	}

}
