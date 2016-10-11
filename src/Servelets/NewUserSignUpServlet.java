package Servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hiber.ManageUsers;
import Hiber.Users;

/**
 * Servlet implementation class NewUserSignUpServlet
 */
@WebServlet("/NewUserSignUpServlet")
public class NewUserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUserSignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("password");

		String nextURL = "/LoginPage.jsp";
		System.out.println("Add new user details");
		if (ManageUsers.isValidUser(useremail, userpassword) == null) {
			ManageUsers.addUser(username, "customer", userpassword, useremail);
		} else {
			nextURL = "/NewUserSignUp.jsp?exist=yes";
		}

		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
