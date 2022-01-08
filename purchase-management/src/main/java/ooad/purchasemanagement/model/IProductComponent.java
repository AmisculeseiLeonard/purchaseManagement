package ooad.purchasemanagement.model;

public interface IProductComponent {
	

	void move(Warehouse fromWarehouse, Warehouse toWarehouse, Integer quantity);
}
