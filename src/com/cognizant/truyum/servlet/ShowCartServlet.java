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
import com.cognizant.truyum.model.Cart;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long userId = 1;
		CartDao cart = new CartDaoSqlImpl();
		Cart userCart = null;
		/*Try-Catch for Exceptions generated from Empty Cart*/
		try {
			/*Try-Catch for Exceptions generated from Connection Hander*/
			try {
				userCart = cart.getAllCartItems(userId);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("cart", userCart);
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		
		} catch (CartEmptyException e) {
			RequestDispatcher fwd = request.getRequestDispatcher("cart-empty.jsp");
			fwd.forward(request, response);
		}

	}

}
