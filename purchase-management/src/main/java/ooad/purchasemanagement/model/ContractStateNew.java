package ooad.purchasemanagement.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContractStateNew extends AbstractContractState{
	
	public ContractStateNew() {
		super();
	}

	public ContractStateNew(@NotBlank @Size(max = 100) String contractState) {
		super(contractState);
	}

	@Override
	public void showCurrentState() {
		System.out.println("The current state is 'New'");
	}

}
