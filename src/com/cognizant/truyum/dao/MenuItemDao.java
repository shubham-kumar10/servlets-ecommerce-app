package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin() throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	public void modifyMenuItem(MenuItem menuItem) throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	public MenuItem getMenuItem(long menuItemId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	public List<MenuItem> getMenuItemListCustomer() throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

}
