package com.cognizant.truyum.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long userId = 1;
		long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		try {
			CartDao cart = new CartDaoSqlImpl();
			cart.addCartItem(userId, menuItemId);
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			request.setAttribute("menuItemList", menuItemDao.getMenuItemListCustomer());
			request.setAttribute("addCartStatus", true);
			RequestDispatcher rd = request.getRequestDispatcher("menu-item-list-customer.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
