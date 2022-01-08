package ooad.purchasemanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public abstract class AbstractContractType implements IContractType{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank
	@Size(max = 100)
	private String contractTypeName;

	public AbstractContractType() {
		super();
	}

	public AbstractContractType(@NotBlank @Size(max = 100) String contractTypeName) {
		super();
		this.contractTypeName = contractTypeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	
	
	
	

}
