<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Items</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<header>
		<h1 id="truyum-logo">
			truYum<span> <img id="logo" src="images/truyum-logo-light.png"
				alt="logo"> <a id="menulink" href="ShowMenuItemListAdmin">Menu</a>
			</span>
		</h1>
	</header>
	<br />
	<br />
	<br />
	<form name="menuItemForm" method="post" onsubmit="return validateMenuItemForm();" action="EditMenuItemServlet">
		<table class="edittable">
			<caption id="menu">Edit Menu Item</caption>
			<tr>
				<td colspan=4>
					<h3>Name</h3> <label for="title"> <input id="title"
						type="text" style="width: 100%;" name="name"
						value="${menuItem.name}">
				</label>
				</td>
			</tr>
			<tr>
				<td>
					<h3>Price(Rs.)</h3> <label for="price"> <input id="price"
						type="text" name="price" value="${menuItem.price}">
				</label>
				</td>
				<td>
					<h3>Active</h3> <label for="inStock"> <input id="inStock"
						type="radio" name="active" value="true"
						${menuItem.active? 'checked="checked"' : ''}>Yes <input
						id="inStock" type="radio" name="active" value="false"
						${menuItem.active? '' : 'checked="checked"'}>No
				</label>
				</td>
				<td>
					<h3>Date of Launch</h3> <label for="dateOflaunch"> <input
						id="dateOflaunch" type="text" name="date"
						value='<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${menuItem.dateOfLaunch}'/>'>
	</label>
	</td>
	<td>
	<h3>Category</h3>
	<label for="category">
	<select name="category">
            <option value="Starters" <c:if test="${menuItem.category eq 'Starters'}">selected</c:if>>Starters</option>
            <option value="Main Course" <c:if test="${menuItem.category eq 'Main Course'}">selected</c:if>>Main Course</option>
            <option value="Dessert"<c:if test="${menuItem.category eq 'Dessert'}">selected</c:if>>Dessert</option>
            <option value="Drinks"<c:if test="${menuItem.category eq 'Drinks'}">selected</c:if>>Drinks</option>
    </select>
    </label>
	</td>
</tr>
<tr>
	<td>
	<label for="freedelivery">
	<input id="freedelivery" class="chkbox" type="checkbox" name="freeDelivery" ${menuItem.freeDelivery? 'checked="checked" value="true"': 'value="false"'}>&nbsp;
	<font size="5"><b>Free Delivery</b></font>
	</label>
	<input type="hidden" value="${menuItem.id}" name="id" />
	</td>
</tr>
<tr>
<td>
<button id="save-button">Save</button></td>
</tr>
</table>
</form>
<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
<script src="js/script.js"></script>
</body>
</html>
</body>
</html>