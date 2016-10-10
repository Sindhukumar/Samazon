import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageUsers {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManageUsers ME = new ManageUsers();

      /* Add few employee records in database */
      Integer u1 = ME.addUser("Zara", "customer", "pass","u1@d.com");
      Integer u2 = ME.addUser("Daisy", "customer", "pass","u2@d.com");
      Integer u3 = ME.addUser("John", "customer", "pass","u3@d.com");
      System.out.println("---->"+u1+"---->"+u2+"--->"+u3);
      
      
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
   public Integer addUser(String username, String userrole, String userpassword, String useremail){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         Users user = new Users( username,  userrole,  userpassword,  useremail);
         employeeID = (Integer) session.save(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   /* Method to  READ all the employees */
   public void listUsers( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List users = session.createQuery("FROM Users").list(); 
         for (Iterator iterator = 
                           users.iterator(); iterator.hasNext();){
            Users user = (Users) iterator.next(); 
            System.out.print("Name: " + user.getUsername()); 
            System.out.print("Password: " + user.getUserpassword()); 
            System.out.println("Role: " + user.getUserrole()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE salary for an employee */
   public void updateUser(Integer userid, String useremail ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Users user = 
                    (Users)session.get(Users.class, userid); 
         user.setUseremail(useremail);
		 session.update(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE an employee from the records */
   public void deleteUser(Integer userid){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Users employee = 
                   (Users)session.get(Users.class, userid); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}