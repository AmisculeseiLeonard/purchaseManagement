package ooad.purchasemanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Invoice extends Document{

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<InvoiceLine> invoiceLines;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	public Invoice() {
		super();
	}

	
	public Invoice(Supplier supplier, Date date, @Size(max = 300) String remark, PaymentMethod paymentMethod) {
		super(supplier, date, remark);
		this.paymentMethod = paymentMethod;
	}


	public void addInvoiceLine(InvoiceLine invoiceLine) {
		if(invoiceLines == null) {
			invoiceLines = new ArrayList<InvoiceLine>();
		}
		invoiceLines.add(invoiceLine);
		
	}
	
	public Double getTotal() {
		if(invoiceLines == null) 
			return 0.0;
		else {
			return invoiceLines
					.stream()
					.mapToDouble(line -> line.getCantitate() * line.getPret())
					.sum();
		}
	}



	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines;
	}


	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}


	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	
	
	
	

	
	
	

}
