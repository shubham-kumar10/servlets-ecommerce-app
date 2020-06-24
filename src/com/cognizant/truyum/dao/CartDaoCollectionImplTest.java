package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws ParseException, CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1);
		cartDao.addCartItem(1, 2);
		Cart cart = null;
		try {
			cart = cartDao.getAllCartItems(1);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (MenuItem itr : cart.getMenuItemList()) {
			System.out.println(itr);
		}
	}

	public static void testRemoveCartItem() throws ParseException, CartEmptyException {

		try {
			CartDao cartDao = new CartDaoCollectionImpl();
			System.out.println("remove");
			try {
				cartDao.removeCartItem(1, 1);
				cartDao.removeCartItem(1, 2);
				cartDao.removeCartItem(1, 2);
				for (MenuItem itr : cartDao.getAllCartItems(1).getMenuItemList())
					System.out.println(itr);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (CartEmptyException e) {
			System.out.println("Cart is Empty now");
		}
	}

	public static void main(String[] args) throws Exception {
		testAddCartItem();
		testRemoveCartItem();
	}
}
