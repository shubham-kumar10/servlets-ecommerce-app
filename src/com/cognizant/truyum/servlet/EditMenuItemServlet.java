package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItemServlet")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		boolean isActive = Boolean.parseBoolean(request.getParameter("active"));
		String date = request.getParameter("date");
		String category = request.getParameter("category");
		boolean freeDelivery = request.getParameter("freeDelivery") == null ? false : true;
		Date dateOfLaunch = null;
		try {
			dateOfLaunch = DateUtil.convertToDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MenuItem newMenuItem = new MenuItem(id, name, price, isActive, dateOfLaunch, category, freeDelivery);
		try {
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			System.out.print(newMenuItem);
			menuItemDao.modifyMenuItem(newMenuItem);
			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
