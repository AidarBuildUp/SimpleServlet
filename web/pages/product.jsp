<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="Entity.Product" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashSet" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>

</head>
    <body>
        <h2>Product</h2>
        <h3>Id ${product.id}</h3>
        <h3>Name ${product.name}</h3>
        <h2><a href="./basket.add?id=${product.id}">Add to basket</a> </h2>

        <h2>Busket</h2>
        <ul>
            <% if (session.getAttribute("basket") != null) {
                    Map <Product, Long> basket = (Map <Product, Long>) session.getAttribute("basket");

                    for (Product productInBasket : basket.keySet()){%>
                        <li> <%= productInBasket.getName()%>  <%= basket.get(productInBasket)%> (<a href="./basket.del?id=<%=productInBasket.getId()%>">X</a>) </li>
                    <%}
            }%>
        </ul>
        <h4><a href="./products"> Back to main menu</a> </h4>

    </body>
</html>