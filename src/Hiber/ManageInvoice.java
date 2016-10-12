package Hiber;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageInvoice {
	/* Method to CREATE an Invoice in the database */
	public static Integer addInvoice(Users user, String invoicedate) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Integer invoiceid = null;
		try {
			tx = session.beginTransaction();
			Invoice invoice = new Invoice(user,invoicedate);
			invoiceid = (Integer) session.save(invoice);
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
	public List<Invoice> listInvoice() {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		List<Invoice> invoices = null;
		try {
			tx = session.beginTransaction();
			invoices = session.createQuery("FROM Invoice").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return invoices;
	}

	public static List<Invoice> invoiceOf(Users user) {
		Session session = Factory.getFactory().openSession();
		String qString = "from Invoice i " + "where i.user = :user";
		List<Invoice> invoices = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(qString);
			q.setParameter("user", user);
			invoices = q.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return invoices;

	}
	
	public static Invoice invoiceById(int invoiceid) {
		Session session = Factory.getFactory().openSession();
		String qString = "from Invoice i " + "where i.invoiceid = :invoiceid";
		Invoice invoice = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(qString);
			q.setParameter("invoiceid", invoiceid);
			List<Invoice>invoices = q.list();
			if (!invoices.isEmpty())
				invoice = invoices.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return invoice;

	}

}
