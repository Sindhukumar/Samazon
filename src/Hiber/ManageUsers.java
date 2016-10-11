package Hiber;
import java.util.List;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManageUsers {

	public void testUser() {
		ManageUsers ME = new ManageUsers();

		/* Add few employee records in database */
		Integer u1 = ME.addUser("Zara", "customer", "pass", "u1@d.com");
		Integer u2 = ME.addUser("Daisy", "customer", "pass", "u2@d.com");
		Integer u3 = ME.addUser("John", "customer", "pass", "u3@d.com");

		/* List down all the employees */
		ME.listUsers();

		/* Update employee's records */
		ME.updateUser(u1, "n@d.com");

		/* Delete an employee from the database */
		ME.deleteUser(u2);

		/* List down new list of the employees */
		ME.listUsers();
	}

	/* Method to CREATE an employee in the database */
	public static Integer addUser(String username, String userrole, String userpassword, String useremail) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Users user = new Users(username, userrole, userpassword, useremail);
			employeeID = (Integer) session.save(user);
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

	/* Method to READ all the employees */
	public void listUsers() {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List users = session.createQuery("FROM Users").list();
			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				Users user = (Users) iterator.next();
				System.out.print("Name: " + user.getUsername());
				System.out.print("Password: " + user.getUserpassword());
				System.out.println("Role: " + user.getUserrole());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static Users isValidUser(String useremail, String userpassword) {
		Session session = Factory.getFactory().openSession();
		String qString = "from Users r " + "where r.useremail = :useremail and r.userpassword = :userpassword";
		Users user = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(qString);
			q.setParameter("useremail", useremail);
			q.setParameter("userpassword", userpassword);
			List<Users> users = q.list();
			if (!users.isEmpty())
				user = users.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;

	}

	/* Method to UPDATE salary for an employee */
	public void updateUser(Integer userid, String useremail) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Users user = (Users) session.get(Users.class, userid);
			user.setUseremail(useremail);
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteUser(Integer userid) {
		Session session = Factory.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Users employee = (Users) session.get(Users.class, userid);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}