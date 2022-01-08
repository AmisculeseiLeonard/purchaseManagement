package ooad.purchasemanagement.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Warehouse {
	
	private String warehouseName;
	
	private Map<IProductComponent, Integer> products;

	public Warehouse(String warehouseName) {
		super();
		this.warehouseName = warehouseName;
	}
	
	public void addComp(IProductComponent product, Integer quantity) {
		if (products == null) {
			products = new HashMap<IProductComponent, Integer>();
		}
		
		if (products.containsKey(product)) {
			products.put(product, products.get(product) + quantity);
		}else {
			products.put(product, quantity);
		}
	}
	
	public void removeComp(IProductComponent product, Integer quantity) {
		if (products == null) {
			products = new HashMap<IProductComponent, Integer>();
			System.out.println("No products are stored in this warehouse at the moment");
			return;
		}
		
		if (products.containsKey(product) && products.get(product) - quantity >= 0) {
			products.put(product, products.get(product) - quantity);
		}else {
			System.out.println("The quantity you want to remove is "
					+ "greater than the existing quantity in the warehouse");
		}
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}



	public Map<IProductComponent, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<IProductComponent, Integer> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(warehouseName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(warehouseName, other.warehouseName);
	}
	
	
	
	

}
