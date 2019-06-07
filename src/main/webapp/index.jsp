<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.food.classes.* "%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.food.servlets.ShopServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <link href="styles/main2.css" rel="stylesheet">
    <title>Люблю градиент</title>
    <body>
    <div class="back">
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private double sum = 0.0;%>
        <%! private List<Long> FoodZakaz;%>

        <%! ArrayList<Food> foodView = new ArrayList<Food>();%>
        <%foodView = Data.getInstance().getFoods();%>
        <%g= foodView.size();%>

        <h1>Меню забегаловки:</h1>
        <% if (request.getAttribute("list") == null) {%>
            <% request.setAttribute("list", new ArrayList());%>
        <%}%>

        <% ((List)request.getAttribute("list")).clear(); %>

        <% for (int i=1; i<=g; i++) {%>
        <% ((List)request.getAttribute("list")).add (Data.getInstance().getFoodById(i)); %>
        <%}%>

        <div class="wrapper">
            <c:forEach items="${list}" var="item">
                <% ++ig; %>
                <div class="element">
                    <span><b>${item.name}</b></span>
                    <span>Цена: ${item.price}</span>
                    <img src="${item.img}" alt="food img" class="img" />
                    <form id=<%=ig%> name="BuyFoodBtn" method="post" action="/shop">
                        <input id="btn" value=<%=ig%> class="input" name="button" />
                        <button type="submit" class="button">Купить</button>
                    </form>
                </div>
            </c:forEach>
        </div>

        <%((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>
        <% Long idU = (Long) request.getSession().getAttribute("idUser"); %>
        <% FoodZakaz = Data.getInstance().getZakazByUser(idU).getFoods(); %>
        <% if (FoodZakaz.size() != 0) {%>
            <h1>Корзина (<%=FoodZakaz.size()%>):</h1>
        <%}%>

        <div class="wrapper">
            <% sum=0.0; %>
            <%for (int j = 0; j< FoodZakaz.size(); j++){ %>
            <% sum = sum + Data.getInstance().getFoodById(FoodZakaz.get(j)).getPrice(); %>
                <div class="element">
                    <span><b>
                        <%=Data.getInstance().getFoodById(FoodZakaz.get(j)).getName()%>
                    </b></span>
                    <span>
                        Цена: <%=Data.getInstance().getFoodById(FoodZakaz.get(j)).getPrice()%>
                    </span>
                    <img src="<%=Data.getInstance().getFoodById(FoodZakaz.get(j)).getImg()%>" alt="food img" class="img" />
                </div>
            <% } %>
        </div>

        <% if (FoodZakaz.size() != 0) {%>
            <h1>Сумма: <%=sum%></h1>
        <%}%>
        <%-- } --%>
    </div>
    </body>
</html>
