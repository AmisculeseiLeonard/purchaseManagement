package ooad.purchasemanagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements IProductComponent{
	
	@Id
	private String productCode;
	
	private String productName;
	
	private String um;
	
	private Double price;
	
	//private Warehouse warehouse;

	public Product() {
		super();
	}

	public Product(String productName, String um, Double price) {
		super();
		this.productName = productName;
		this.um = um;
		this.price = price;
		
	}
	
	@Override
	public void move(Warehouse fromWarehouse, Warehouse toWarehouse, Integer quantity) {
		fromWarehouse.removeComp(this, quantity);
		toWarehouse.addComp(this, quantity);
		
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, productName, um);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(price, other.price) && Objects.equals(productName, other.productName)
				&& Objects.equals(um, other.um);
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", um=" + um + ", price=" + price + "]";
	}
	
	

	

	

	
	
	
	

	
	
	

}
