package io.ollg.store.servlet;

import io.ollg.store.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart;
        if(req.getSession().getAttribute("cart") == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
            req.setAttribute("cartItems", cart.getItems());
        } else {
            cart = (Cart) req.getSession().getAttribute("cart");
            req.setAttribute("cartItems", cart.getItems());
        }
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Cart should already exist, but maybe I should add another test

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer id = Integer.valueOf(req.getParameter("id"));
        if(req.getParameter("change") != null){
            Integer amount = Integer.valueOf(req.getParameter("amount"));
            cart.setAmount(id, amount);
        }else if(req.getParameter("delete") != null){
            cart.removeProduct(id);
        }

        resp.sendRedirect("./cart");
    }
}
