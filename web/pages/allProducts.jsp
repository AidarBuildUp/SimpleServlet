<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="Entity.Product" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Products</title>

</head>
    <body>
        <h2>Products</h2>
        <% List <Product> products = (List<Product>) request.getAttribute("products"); %>
        <ul>
            <% for (Product product: products) { %>
            <li><a href="<%= request.getContextPath()%>/product?id=<%=product.getProductCode()%>"> <%= product.getName()%> </a></li>
            <% } %>
        </ul>

    </body>
</html>