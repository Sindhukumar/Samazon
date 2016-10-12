package Servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hiber.Cart;
import Hiber.Invoice;
import Hiber.ManageInvoice;
import Hiber.ManageOrder;
import Hiber.Order;
import Hiber.Receipt;
import Hiber.Users;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/OrderHistory.jsp";
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Invoice> invoices = ManageInvoice.invoiceOf(user);

		List<Receipt> history = new ArrayList<Receipt>();
		for (Invoice invoice : invoices) {
			history.add(new Receipt(user, invoice));
		}
		session.setAttribute("history", history);
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
		doGet(request, response);
	}

}
