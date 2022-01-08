package ooad.purchasemanagement.model;

public class ContractTypeFixedPrice extends AbstractContractType{

	@Override
	public Double calculateCost() {
		System.out.println("Calculating cost for fixed-price contract");
		return null;
	}

}
