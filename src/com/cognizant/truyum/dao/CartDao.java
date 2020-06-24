package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.truyum.model.Cart;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId) throws ParseException;

	public Cart getAllCartItems(long userId)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	public void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException;
}
