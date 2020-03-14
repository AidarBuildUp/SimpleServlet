<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="Entities.Product" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>

</head>
    <body>
        <h2>Product</h2>
        <% Product product = (Product) request.getAttribute("product");%>
        <h3>Code <%= product.getProductCode()%></h3>
        <h3>Name <%= product.getName()%></h3>
        <h2><a href="<%= request.getContextPath()%>/product?id=<%=product.getProductCode()%>&action=add">Add to basket</a> </h2>
        <h2><a href="<%= request.getContextPath()%>/product?id=<%=product.getProductCode()%>&action=add">Remove from one item basket</a> </h2>
    </body>
</html>