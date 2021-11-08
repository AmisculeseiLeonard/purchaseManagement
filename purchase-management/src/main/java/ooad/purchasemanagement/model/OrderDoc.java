package ooad.purchasemanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class OrderDoc extends Document{
	
	private boolean isInvoiceGenerated;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderLine> orderLines;

	public OrderDoc() {
		super();
	}

//	public Order(Supplier supplier, Date date, @Size(max = 300) String remark) {
//		super(supplier, date, remark);
//		this.isInvoiceGenerated = false;
//	}
	public OrderDoc(Supplier supplier, Date date, @Size(max = 300) String remark, boolean isInvoiceGenerated) {
		super(supplier, date, remark);
		this.isInvoiceGenerated = isInvoiceGenerated;
		
	}
	
	
	public void addOrderLine(OrderLine orderLine) {
		if(orderLines == null) {
			orderLines = new ArrayList<OrderLine>();
		}
		orderLines.add(orderLine);
		
	}

	

	public boolean isInvoiceGenerated() {
		return isInvoiceGenerated;
	}

	public void setInvoiceGenerated(boolean isInvoiceGenerated) {
		this.isInvoiceGenerated = isInvoiceGenerated;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
	
	
	
	
	
}
