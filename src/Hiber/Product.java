package Hiber;
import java.math.BigDecimal;

public class Product {
	private int productid;
	private String productname;
	private String productdescription;
	private Double price;
	private Double instock;

	Product() {

	}

	Product(String productname, String productdescription, Double price, Double instock) {
		this.productname = productname;
		this.productdescription = productdescription;
		this.price = price;
		this.instock = instock;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getInstock() {
		return instock;
	}

	public void setInstock(Double instock) {
		this.instock = instock;
	}

}
