package Servelets;

import java.io.IOException;
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
import Hiber.Users;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "/Sucess.jsp";
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.checkout();
		Users user = (Users) session.getAttribute("user");
		cart = new Cart(user);
		session.setAttribute("cart", cart);
		//getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		response.sendRedirect(request.getContextPath()+nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
