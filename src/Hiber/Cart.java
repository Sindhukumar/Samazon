package Hiber;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
	private Users user;
	private ArrayList<Order> orders;
	private double subtotal;
	private int numberoforders;
	public int getNumberoforders() {
		return numberoforders;
	}
	public void setNumberoforders(int numberoforders) {
		this.numberoforders = numberoforders;
	}
	public Cart(Users user){
		this.user = user;
		orders = new ArrayList<Order>();
	}
	public void addOrder(Order order){
		orders.add(order);
		numberoforders = orders.size();
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public double getSubtotal() {
		double total=0;
		for(Order order:orders){
			total+=(order.getSellingprice()+order.getTax()+order.getShippingcost());
		}
		subtotal = Math.round( total * .06*100.0)/100.0;
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public void checkout(){
		String date = new Date().toString();
		Invoice invoice = ManageInvoice.invoiceById(ManageInvoice.addInvoice(user, date));
		for(Order order:orders){
			order.setInvoice(invoice);
			ManageOrder.addOrder(order);
		}
		
		
	}
}
