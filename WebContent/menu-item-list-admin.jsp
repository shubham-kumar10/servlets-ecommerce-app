<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	
%>
<title>Admin Menu Item List</title>
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
	<h1 id="menu">Menu Items</h1>
	<table class="menutable">
	<tr>
		<th class="th_leftaln">Name</th>
		<th class="th_rightaln">Price</th>
		<th class="th_center">Active</th>
		<th class="th_center">Date of Launch</th>
		<th class="th_center">Category</th>
		<th class="th_center">Free Delivery</th>
		<th class="th_center">Action</th>
	</tr>
		<c:forEach items="${menuItemList}" var="menuItem">
			<tr>
				<td class="th_leftaln"><c:out value="${menuItem.name}" /></td>
				<td class="th_rightaln"><fmt:formatNumber
						value="${menuItem.price}" type="currency" currencySymbol="Rs. " /></td>
				<td class="th_center"><c:out value="${menuItem.active == true ? 'Yes' : 'No'}" /></td>
				<td class="th_center"><fmt:formatDate type="date" pattern="dd/MM/yyyy" dateStyle="short"
						value="${menuItem.dateOfLaunch}" /></td>
				<td class="th_center"><c:out value="${menuItem.category}" /></td>
				<td class="th_center"><c:out value="${menuItem.freeDelivery == true ? 'Yes' : 'No'}" /></td>
				<td class="th_center"><a href="ShowEditMenuItem?menuItemId=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
</body>
</html>