<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<header>
	<h1 id="truyum-logo">truYum<span>
	<img id="logo" src="images/truyum-logo-light.png" alt="logo">
	<a id="menulink" href="ShowCart">Cart</a>
	<a id="menulink" href="ShowMenuItemListCustomer">Menu</a>
	</span></h1>
</header>
<br/>
<br/>
<br/>
<p id="menu">Cart</p>
<c:if test="${removeCartItemStatus}"><center><p id="greentxt">Item removed from cart successfully</p></center></c:if>
<table class="edittable">
<tr>
	
		<th class="th_leftaln">Name</th>
		<th class="th_center">Free Delivery</th>
		<th class="th_rightaln">Price</th>
		<th class="th_center"></th>
	
	</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr>
				<td class="th_leftaln"><c:out value="${menuItem.name}" /></td>
				<td class="th_center"><c:out
						value="${menuItem.freeDelivery == true ? 'Yes' : 'No'}" /></td>
				<td class="th_rightaln"><fmt:formatNumber
						value="${menuItem.price}" type="currency" currencySymbol="Rs. " /></td>
				<td class="th_center"><a
					href="RemoveCartItem?menuItemId=${menuItem.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
		<td class="leftaln"></td>
		<td class="center"><b>Total</b></td>
		<td class="rightaln"><b><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cart.total}" /></b></td>
		<td class="center"><a href="cart-notification.html"></a></td>
	</tr>
	</table>
<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
</body>
</html>

</body>
</html>