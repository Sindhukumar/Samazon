import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Hiber.ManageProduct;
import Hiber.ManageUsers;
import Hiber.Product;
import Hiber.Users;

public class TestDB {

	@Test
	public void test() {
		ManageUsers ME = new ManageUsers();
		ME.listUsers();
		Users user = ME.isValidUser("n@d.com", "pass");
		System.out.println(user.getUserid());
		ManageProduct mp = new ManageProduct();
		//mp.addProduct("Vitamin A", "80% daily requirement of vitamin A", 49.00, 8.0);
		List<Product> products= mp.listProductsinStock();
		for(Product product : products){
			System.out.println(product.getProductid());
		}
	}

}
