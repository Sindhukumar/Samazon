package Hiber;
public class Invoice {

	int invoiceid;
	Users user;
	String invoicedate;

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public Invoice() {

	}

	public Invoice(Users user) {
		this.user = user;
	}

	public Invoice(Users user, String invoicedate) {
		this.user = user;
		this.invoicedate = invoicedate;
	}
	
	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
