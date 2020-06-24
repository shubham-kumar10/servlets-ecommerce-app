package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void testAddCartItem()
			throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1, 1);
		cartDao.addCartItem(1, 2);
		Cart cart = cartDao.getAllCartItems(1);
		for (MenuItem itr : cart.getMenuItemList()) {
			System.out.println(itr);
		}
	}

	public static void testRemoveCartItem() {

		try {
			CartDao cartDao = new CartDaoSqlImpl();
			System.out.println("remove 1");
			cartDao.removeCartItem(1, 1);
			cartDao.removeCartItem(1, 2);
			cartDao.removeCartItem(1, 2);
			for (MenuItem itr : cartDao.getAllCartItems(1).getMenuItemList())
				System.out.println(itr);
		} catch (CartEmptyException e) {
			System.out.println("Cart is Empty now");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// testAddCartItem();
		testRemoveCartItem();
	}
}
