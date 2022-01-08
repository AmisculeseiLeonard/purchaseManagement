package ooad.purchasemanagement.model;

public class ContractTypeCostReimbursement extends AbstractContractType{

	@Override
	public Double calculateCost() {
		System.out.println("Calculating cost for cost-reimbursement contract");
		return null;
	}

}
