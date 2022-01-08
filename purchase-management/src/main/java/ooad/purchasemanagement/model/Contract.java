package ooad.purchasemanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

@Entity
public class Contract extends Document{
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "contract_state_id")
	private AbstractContractState contractState;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "contract_type_id")
	private AbstractContractType contractType;
	
	@Temporal(TemporalType.DATE)
	@Future
	private Date endDate;
	
	@Size(max = 500)
	private String description;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(Supplier supplier, Date date, @Size(max = 300) String remark, Date endDate, String description) {
		super(supplier, date, remark);
		this.endDate = endDate;
		this.description = description;
	}
	
	public void showCurrentState() {
		contractState.showCurrentState();
	}

	public AbstractContractState getContractState() {
		return contractState;
	}

	public void setContractState(AbstractContractState contractState) {
		this.contractState = contractState;
	}

	public AbstractContractType getContractType() {
		return contractType;
	}

	public void setContractType(AbstractContractType contractType) {
		this.contractType = contractType;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	

	
	
	

}
