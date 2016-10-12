package Hiber;

import java.util.List;

public class Receipt {

	private Users user;
	private Invoice invoice;
	private List<Order> orders;
	private double subtotal;

	public Receipt(Users user, Invoice invoice) {
		this.user = user;
		this.invoice = invoice;
		orders = ManageOrder.orderOf(invoice);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public double getSubtotal() {
		double total = 0;
		for (Order order : orders) {
			total += (order.getSellingprice() + order.getTax() + order.getShippingcost());
		}
		subtotal = Math.round(total * .06 * 100.0) / 100.0;
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
