package ooad.purchasemanagement;

import java.util.Map.Entry;

import ooad.purchasemanagement.model.IProductComponent;
import ooad.purchasemanagement.model.Package;
import ooad.purchasemanagement.model.Product;
import ooad.purchasemanagement.model.Warehouse;

public class CompositeTest {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse("warehouse1");
		Warehouse warehouse2 = new Warehouse("warehouse2");
		
		Product prod1 = new Product("Laptop HP", "Buc", 3500.0);
		Product prod2 = new Product("Mouse", "Buc", 100.0);
		
		Package package1 = new Package("Office Package");
		package1.addProduct(prod1);
		package1.addProduct(prod2);
		
		warehouse.addComp(prod2, 20);
		warehouse.addComp(prod1, 10);
		
		//warehouse.removeComp(prod2, 15);
		
		prod2.move(warehouse, warehouse2, 15);
		package1.move(warehouse, warehouse2, 3);
		
		
		for (IProductComponent  prod: package1.getProducts()) {
			System.out.println("Package: " + package1.getPackageName() + ". " + prod);
		}
		
		for (Entry<IProductComponent, Integer> prod : warehouse.getProducts().entrySet()) {
			System.out.println("Warehouse: " + warehouse.getWarehouseName() 
					+ ". Product: " + ((Product) prod.getKey()).getProductName() 
					+ ". Quantity: " + prod.getValue());
		}
		
		for (Entry<IProductComponent, Integer> prod : warehouse2.getProducts().entrySet()) {
			System.out.println("Warehouse: " + warehouse2.getWarehouseName() 
					+ ". Product: " + ((Product) prod.getKey()).getProductName() 
					+ ". Quantity: " + prod.getValue());
		}
		
		
	}

}
