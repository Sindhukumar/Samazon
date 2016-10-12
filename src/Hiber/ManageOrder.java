package Hiber;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageOrder {

	/* Method to CREATE an Order in the database */
	public static Integer addOrder(Invoice invoice, Product product, double sellingprice, double tax, double shippingcost) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Integer invoiceid = null;
		try {
			tx = session.beginTransaction();
			Order order = new Order( invoice,  product,  sellingprice,  tax,  shippingcost);
			invoiceid = (Integer) session.save(order);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return invoiceid;
	}
	
	public static Integer addOrder(Order order) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Integer invoiceid = null;
		try {
			tx = session.beginTransaction();
			invoiceid = (Integer) session.save(order);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return invoiceid;
	}

	/* Method to READ all the Invoices */
	public List<Order> listInvoice() {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		List<Order> orders = null;
		try {
			tx = session.beginTransaction();
			orders = session.createQuery("FROM Invoice").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orders;
	}

	public static List<Order> orderOf(Invoice invoice) {
		Session session = Factory.getFactory().openSession();
		String qString = "from Order i " + "where i.invoice = :invoice";
		List<Order> orders = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(qString);
			q.setParameter("invoice", invoice);
			orders = q.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orders;

	}

}
