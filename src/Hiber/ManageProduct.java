package Hiber;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageProduct {
	
	public static Integer addProduct(String productname, String productdescription, Double price, Double instock) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Product product = new Product(productname, productdescription, price, instock);
			employeeID = (Integer) session.save(product);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	public static List<Product> listProducts() {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		List<Product> products = null;
		try {
			tx = session.beginTransaction();
			products = session.createQuery("FROM Product").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}

	public static List<Product> listProductsinStock() {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		List<Product> products = null;
		try {
			tx = session.beginTransaction();
			products = session.createQuery("FROM Product where instock > 0").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}
	
	public static Product getProductbyID(int productid) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Product product = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Product where productid = :productid");
			q.setParameter("productid", productid);
			List<Product> l = q.list();
			if(!l.isEmpty())
			product = l.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;
	}
}
