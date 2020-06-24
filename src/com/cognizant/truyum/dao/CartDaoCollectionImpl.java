package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
			userCarts.put(1L, new Cart(menuItemList, 0));
		}
	}

	public void addCartItem(long userId, long menuItemId) throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = null;
		try {
			menuItem = menuItemDao.getMenuItem(menuItemId);
		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Cart userCartTemp;
		if (userCarts.containsKey(userId)) {
			userCartTemp = userCarts.get(userId);
			menuItemList = userCartTemp.getMenuItemList();
			menuItemList.add(menuItem);
			userCartTemp.setMenuItemList(menuItemList);
			userCarts.put(userId, userCartTemp);
		} else {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart userCart = new Cart(menuItemList, 0.0);
			userCarts.put(userId, userCart);
		}
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList;
		Cart cart;
		if (userCarts.get(userId) == null) {
			throw new CartEmptyException();
		} else {
			double total = 0.0;
			cart = userCarts.get(userId);
			menuItemList = cart.getMenuItemList();

			if (menuItemList.isEmpty())
				throw new CartEmptyException();
			for (MenuItem itr : menuItemList) {
				total = total + itr.getPrice();
			}
			cart.setTotal(total);
			return cart;
		}
	}

	public void removeCartItem(long userId, long menuItemId) {

		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Cart cart = userCarts.get(userId);
		System.out.println(cart.getMenuItemList());
		try {
			menuItemList = cart.getMenuItemList();
			if (menuItemList.isEmpty())
				throw new CartEmptyException();
			else {
				for (int i = 0; i < menuItemList.size(); i++) {
					if (menuItemList.get(i).getId() == menuItemId) {
						menuItemList.remove(i);
					}
				}

			}
		} catch (CartEmptyException e) {
			System.out.println("Cart is Empty");
		}

	}
}
