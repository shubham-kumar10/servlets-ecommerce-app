package com.cognizant.truyum.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;

/**
 * Servlet implementation class ShowEditMenuItemServlet
 */
@WebServlet("/ShowEditMenuItem")
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
			request.setAttribute("menuItem", menuItemDao.getMenuItem(menuItemId));
			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
