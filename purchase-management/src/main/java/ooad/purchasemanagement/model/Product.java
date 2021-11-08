package ooad.purchasemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private String productCode;
	
	private String productName;
	
	private String um;
	
	

	public Product() {
		super();
	}

	public Product(String productName, String um) {
		super();
		this.productName = productName;
		this.um = um;
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
	
	

}
