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
import Hiber.Factory;
import Hiber.ManageUsers;
import Hiber.Users;


/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");

		String nextURL ="/error.jsp";

		Users user= ManageUsers.isValidUser(useremail, userpassword);	
		HttpSession session = request.getSession();
		if(user!=null)
		{
			session.setAttribute("user", user);
			session.setAttribute("gravatarURL", Factory.getGravatarURL(useremail, 50));
			Cart cart =  new Cart(user);
			session.setAttribute("cart", cart);
			nextURL="/Home";
		}

		else
		{
			nextURL="/LoginPage.jsp"; 
		}
		response.sendRedirect(request.getContextPath()+nextURL);
	}

	
}
