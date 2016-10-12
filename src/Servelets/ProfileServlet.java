package Servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hiber.ManageUsers;
import Hiber.Users;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextURL = "/Profile.jsp?action=viewprofile";
		if ("editprofile".equalsIgnoreCase(request.getParameter("action"))) {
			nextURL = "/Profile.jsp?action=editprofile";
		}

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");

		// getServletContext().getRequestDispatcher(nextURL).forward(request,
		// response);
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextURL = "/ProfileServlet";
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");

		HttpSession session = request.getSession();

		Users user = (Users) session.getAttribute("user");

		ManageUsers.updateUser(user.getUserid(), useremail, userpassword, username, "customer");
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}