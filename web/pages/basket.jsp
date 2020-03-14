<%@ page import="Basket.BasketImpl" %>
<%@ page import="Entities.BaseProduct" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: aidar
  Date: 13.03.2020
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%BasketImpl basketContainer = (BasketImpl) request.getAttribute("basket");
      Map<BaseProduct, Long>  basket = basketContainer.getAllItems();
      LinkedHashSet<BaseProduct> products = (LinkedHashSet<BaseProduct>) basket.keySet();

        for (BaseProduct product: products
             ) {%>

                <h2><%=product.getName()%> <%=basket.get(product)%></h2>

        <%}%>
</body>
</html>
