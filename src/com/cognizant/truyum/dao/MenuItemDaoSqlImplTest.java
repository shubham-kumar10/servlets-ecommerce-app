package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String args[]) throws Exception {
		System.out.println("----------Admin List-----------");
		testGetMenuItemListAdmin();
		System.out.println("----------Customer List-----------");
		testGetMenuItemListCustomer();
		/*
		 * System.out.println("----------Edit List-----------");
		 * testModifyMenuItem();
		 */
		System.out.println("----------Admin List-----------");
		testGetMenuItemListAdmin();

	}

	public static void testGetMenuItemListAdmin() throws Exception {

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		// Iteration
		Iterator<MenuItem> itr = menuItemList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void testGetMenuItemListCustomer() throws Exception {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem itr : menuItemList) {
			System.out.println(itr);
		}
	}

	public static void testModifyMenuItem() throws Exception {
		MenuItem menuItem = new MenuItem(1, "New Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(1));
	}
}
