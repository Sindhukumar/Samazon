package Hiber;

public class Order {
	private int orderid;
	private Invoice invoice;
	private Product product;
	private double sellingprice;
	private double tax;
	private double shippingcost;

	Order() {

	}

	Order(Invoice invoice, Product product, double sellingprice, double tax, double shippingcost) {
		this.invoice = invoice;
		this.product = product;
		this.sellingprice = sellingprice;
		this.tax = tax;
		this.shippingcost = shippingcost;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	public double getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getShippingcost() {
		return shippingcost;
	}

	public void setShippingcost(double shippingcost) {
		this.shippingcost = shippingcost;
	}
}
