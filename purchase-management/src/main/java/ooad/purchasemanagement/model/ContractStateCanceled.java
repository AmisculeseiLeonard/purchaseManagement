package ooad.purchasemanagement.model;

public class ContractStateCanceled extends AbstractContractState{

	@Override
	public void showCurrentState() {
		System.out.println("The current state is 'Canceled'");
	}

}
