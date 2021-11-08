package ooad.purchasemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "ooad.purchasemanagement")
public class PurchaseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseManagementApplication.class, args);
		
	
	}
	

}
