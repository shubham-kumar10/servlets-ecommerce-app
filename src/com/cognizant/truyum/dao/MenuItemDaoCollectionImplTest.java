package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String args[]) throws ParseException {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItemList;
		try {
			menuItemList = menuItemDao.getMenuItemListAdmin();
			Iterator<MenuItem> itr = menuItemList.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Iteration
}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList;
		try {
			menuItemList = menuItemDao.getMenuItemListCustomer();
			for (MenuItem itr : menuItemList) {
				System.out.println(itr);
			}
		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem(1, "New Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		try {
			menuItemDao.modifyMenuItem(menuItem);
			System.out.println(menuItemDao.getMenuItem(1));
		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
