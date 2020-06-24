package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = null;
		try {

			connection = ConnectionHandler.getConnection();
			String sql = "INSERT INTO truyum.cart(ct_us_id,ct_pr_id) VALUES(?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setLong(2, menuItemId);
			pst.executeUpdate();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// Changed MenuItemList to CART return type
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		Connection connection = null;
		Cart cart = new Cart(null, 0);
		try {

			connection = ConnectionHandler.getConnection();
			String sql = "SELECT menu_item.* FROM cart " + "JOIN menu_item ON menu_item.me_id = cart.ct_pr_id "
					+ "JOIN user ON user.us_id = cart.ct_us_id " + "WHERE user.us_id=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet rs = pst.executeQuery();
			ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
			MenuItem menuItem;
			while (rs.next()) {
				menuItem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				menuItemList.add(menuItem);
			}

			sql = "SELECT SUM(menu_item.me_price) AS TOTAL "
					+ "FROM cart JOIN menu_item ON menu_item.me_id = cart.ct_pr_id "
					+ "JOIN user ON user.us_id = cart.ct_us_id WHERE user.us_id=?";
			if (menuItemList.isEmpty())
				throw new CartEmptyException();

			pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			rs = pst.executeQuery();
			cart.setMenuItemList(menuItemList);
			if (rs.next())
				cart.setTotal(rs.getDouble(1));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cart;
	}

	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = null;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "DELETE FROM cart WHERE cart.ct_pr_id=? and cart.ct_us_id=? limit 1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, menuItemId);
			pst.setLong(2, userId);
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
