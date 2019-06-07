package com.ystu.food.servlets;

import com.ystu.food.classes.Data;
import com.ystu.food.classes.Food;
import com.ystu.food.classes.Zakaz;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Food> list = new ArrayList<Food>();
        req.setAttribute("list", list);

        Long idU =  (Long) req.getSession().getAttribute("idUser");

        if (idU == null) {
            resp.sendRedirect("auth");
        }
        else {
            ArrayList<Zakaz> or = new ArrayList<Zakaz>();
            if (req.getSession().getAttribute("ArrayIdFood") == null){
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else{
                List<Long> Add2Cart=  (List) req.getSession().getAttribute("ArrayIdFood");
                req.getSession().setAttribute("ArrayIdFood",Add2Cart);
                long Uid = idU;
                or.add(new Zakaz(1, Uid, Add2Cart));
                Data.getInstance().setZakazs(or);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Food> list = new ArrayList<Food>();
        req.setAttribute("list", list);

        ArrayList<Zakaz> or = new ArrayList<Zakaz>();
        List<Long> ShopCart = new ArrayList<Long>();

        Long idU =  (Long) req.getSession().getAttribute("idUser");
        long Uid = idU;

        ShopCart = Data.getInstance().getZakazByUser(idU).getFoods();

        if (req.getSession().getAttribute("ArrayIdFood") == null && ShopCart.size()==0){
            List<Long> EmptyCart = new ArrayList<Long>();

            String name = req.getParameter("button");
            EmptyCart.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdFood",EmptyCart);
            ShopCart = EmptyCart;
        }
        else{
            if (req.getSession().getAttribute("ArrayIdFood") == null) {
                List<Long> Add2Cart=ShopCart;
                String name = req.getParameter("button");
                Add2Cart.add(Long.parseLong(name));
                req.getSession().setAttribute("ArrayIdFood",Add2Cart);
                ShopCart = Add2Cart;
            }
            else{
            List<Long> Add2Cart=  (List) req.getSession().getAttribute("ArrayIdFood");
            String name = req.getParameter("button");
            Add2Cart.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdFood",Add2Cart);
            ShopCart = Add2Cart;
            }
        }

        or.add(new Zakaz(1, Uid, ShopCart));
        Data.getInstance().setZakazs(or);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
