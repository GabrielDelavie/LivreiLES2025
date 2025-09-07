package com.livrei.les.ecomercy.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends EntityDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private String barCode;
	private Integer ProductStatus;
	private String justificationForInactivation;
	private String JustificationForActivation;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category",
	joinColumns = @JoinColumn(name = "product_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem>items = new HashSet<>();
	
	public Product() {}
	
	public Product (Long id, String name, String description, Double price, String imgUrl, String barCode, Integer productStatus) {
		super(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.barCode = barCode;
		this.ProductStatus = productStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Integer getProductStatus() {
		return ProductStatus;
	}

	public void setProductStatus(Integer productStatus) {
		ProductStatus = productStatus;
	}

	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> orders = new HashSet<>();
		for(OrderItem oi: items) {
			orders.add(oi.getOrder());
		}
		return orders;
	}
}
