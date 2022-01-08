package ooad.purchasemanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Package implements IProductComponent {
	
	private String packageName;
	
	private List<IProductComponent> products;
	

	public Package(String packageName) {
		super();
		this.packageName = packageName;
	}
	
	public void addProduct(IProductComponent product) {
		if(products == null) {
			products = new ArrayList<IProductComponent>();
		}
		products.add(product);
		
	}
	
	public void deleteProduct(IProductComponent product) {
		if (products.contains(product)) {
			products.remove(product);
		}else {
			System.out.println("There's no such product in this package");
		}
	}
	
	@Override
	public void move(Warehouse fromWarehouse, Warehouse toWarehouse, Integer quantity) {
		for (IProductComponent product : products) {
			fromWarehouse.removeComp(product, quantity);
			toWarehouse.addComp(product, quantity);
		}
		
	}
	

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<IProductComponent> getProducts() {
		return products;
	}

	public void setProducts(List<IProductComponent> products) {
		this.products = products;
	}



}
