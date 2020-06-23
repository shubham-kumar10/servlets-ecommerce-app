package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, DateUtil.convertToDate("21/03/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),
					"Starter", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));
		}
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemListCustomer = new ArrayList<MenuItem>();
		for (MenuItem itr : getMenuItemListAdmin()) {
			if (itr.isActive() && !itr.getDateOfLaunch().after(new Date())) {
				menuItemListCustomer.add(itr);
			}
		}
		return menuItemListCustomer;
	}

	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem itr : menuItemList) {
			if (itr.getId() == (menuItem.getId())) {
				itr.setName(menuItem.getName());
				itr.setPrice(menuItem.getPrice());
				itr.setCategory(menuItem.getCategory());
				itr.setDateOfLaunch(menuItem.getDateOfLaunch());
				itr.setFreeDelivery(menuItem.isFreeDelivery());
				itr.setActive(menuItem.isActive());
			}

		}

	}

	public MenuItem getMenuItem(long menuItemId) {

		Iterator<MenuItem> itr = menuItemList.iterator();
		while (itr.hasNext()) {
			MenuItem menuItem = itr.next();
			if (menuItem.getId() == menuItemId)
				return menuItem;
		}
		return null;
	}
}
