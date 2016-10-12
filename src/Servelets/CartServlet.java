package Servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hiber.Cart;
import Hiber.ManageProduct;
import Hiber.Order;
import Hiber.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/Cart.jsp";
		HttpSession session = request.getSession();
		int productid = Integer.parseInt(request.getParameter("addproduct"));
		Product product = ManageProduct.getProductbyID(productid);
		Cart cart = (Cart) session.getAttribute("cart");
		Order order = new Order(product, product.getPrice(),Math.round( product.getPrice() * .06*100.0)/100.0, 3);
		if (cart == null) {
			nextURL = "/LoginPage.jsp";
		} else {
			cart.addOrder(order);
			session.setAttribute("cart", cart);
		}
		//getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		response.sendRedirect(request.getContextPath()+nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
