package ooad.purchasemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ooad.purchasemanagement.model.AbstractContractState;
import ooad.purchasemanagement.model.Contract;
import ooad.purchasemanagement.model.ContractStateCanceled;
import ooad.purchasemanagement.model.ContractStateDirectorApproval;
import ooad.purchasemanagement.model.ContractStateNew;
import ooad.purchasemanagement.model.IContractState;



@SpringBootApplication
@ComponentScan(basePackages = "ooad.purchasemanagement")
public class PurchaseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseManagementApplication.class, args);
		
		AbstractContractState contractState = new ContractStateDirectorApproval();
		//contractState.showCurrentState();
		
		Contract contract2 = new Contract();
		contract2.setContractState(contractState);
		contract2.showCurrentState();
		contract2.setContractState(new ContractStateCanceled());
		contract2.showCurrentState();
	}
	

}
