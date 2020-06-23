package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin()
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String sql = "SELECT * FROM menu_item";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			MenuItem menuItem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
					rs.getDate(5), rs.getString(6), rs.getBoolean(7));
			menuItemList.add(menuItem);
		}
		System.out.println("from Admin " + menuItemList);
		return menuItemList;

	}

	public List<MenuItem> getMenuItemListCustomer() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		String sql = "SELECT * FROM truyum.menu_item WHERE me_date_of_launch<=CURRENT_DATE() AND me_active = 'YES'";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			MenuItem menuItem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
					rs.getDate(5), rs.getString(6), rs.getBoolean(7));
			menuItemList.add(menuItem);
		}
		System.out.println("from Customer " + menuItemList);
		return menuItemList;
	}

	public MenuItem getMenuItem(long menuItemId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		Connection connection = ConnectionHandler.getConnection();
		String sql = "SELECT * FROM truyum.menu_item WHERE me_id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setLong(1, menuItemId);
		ResultSet rs = pst.executeQuery();
		MenuItem menuItem = null;
		while (rs.next()) {
			menuItem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getDate(5),
					rs.getString(6), rs.getBoolean(7));
		}
		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		Connection connection = ConnectionHandler.getConnection();
		String sql = "UPDATE truyum.menu_item SET me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? WHERE me_id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, menuItem.getName());
		pst.setFloat(2, menuItem.getPrice());
		pst.setString(3, menuItem.isActive()?"YES":"NO");
		pst.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
		pst.setString(5, menuItem.getCategory());
		pst.setBoolean(6, menuItem.isFreeDelivery());
		pst.setLong(7, menuItem.getId());
		pst.executeUpdate();
	}

}
