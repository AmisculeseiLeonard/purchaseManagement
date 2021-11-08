package ooad.purchasemanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Entity
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Positive
	private Double cantitate;
	
	@Positive
	private Double pret;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "order_id")
	private OrderDoc order;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "product_id")
	private Product product;

	public OrderLine() {
		super();
	}

	public OrderLine(@Positive Double cantitate, @Positive Double pret, OrderDoc order, Product product) {
		super();
		this.cantitate = cantitate;
		this.pret = pret;
		this.order = order;
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

	public OrderDoc getOrder() {
		return order;
	}

	public void setOrder(OrderDoc order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
