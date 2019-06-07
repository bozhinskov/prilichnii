<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.food.classes.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.food.servlets.ShopServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <link href="styles/main2.css" rel="stylesheet">
    <title>Войти</title>
    <body>
    <div class="back">
        <%! private int ig = 0;%>

        <h2>Авторизация</h2>
        <form id=<%=ig%> name="LoginShop" method="get">
        <p> Логин: <input type="text" name="login" /></p>
        <p>Пароль:<input type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
        </form>

        <% if (request.getAttribute("msgAuth") != null) {%>
        <% String messageAut = (String) request.getAttribute("msgAuth"); %>
        <c:set var="msgAutView" value="<%=messageAut.toString()%>"/>
        <h3>${msgAutView}</h3>
        <%}%>
    </div>
    </body>
</html>
