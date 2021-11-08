package ooad.purchasemanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class InvoiceLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Positive
	private Double cantitate;
	
	@PositiveOrZero
	private Double pret;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "product_id")
	private Product product;
	

	public InvoiceLine() {
		super();
	}


	public InvoiceLine(@Positive Double cantitate, @PositiveOrZero Double pret, Invoice invoice, Product product) {
		super();
		this.cantitate = cantitate;
		this.pret = pret;
		this.invoice = invoice;
		this.product = product;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getCantitate() {
		return cantitate;
	}


	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}


	public Double getPret() {
		return pret;
	}


	public void setPret(Double pret) {
		this.pret = pret;
	}


	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
