package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartItem")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		CartDao userCart = new CartDaoSqlImpl();
		long userId = 1;

		request.setAttribute("removeCartItemStatus", true);
		try {
			try {
				userCart.removeCartItem(userId, menuItemId);
				request.setAttribute("cart", userCart.getAllCartItems(userId));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (CartEmptyException e) {
			RequestDispatcher cartempty = request.getRequestDispatcher("cart-empty.jsp");
			cartempty.forward(request, response);
		}
	}

}
