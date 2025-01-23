package api.ExcelApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	private Integer ProductId;
	
	private String ProductName;
	
	private String ProductDesc;
	
	private double Price;

	public Product(Integer productId, String productName, String productDesc, double price) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductDesc = productDesc;
		Price = price;
	}

	public Product() {
		
	}

	public Integer getProductId() {
		return ProductId;
	}

	public void setProductId(Integer productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductDesc() {
		return ProductDesc;
	}

	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	
	
	

}
