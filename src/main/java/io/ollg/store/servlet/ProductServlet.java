package io.ollg.store.servlet;

import io.ollg.store.model.Cart;
import io.ollg.store.model.Library;
import io.ollg.store.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "product", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private Library library = Library.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null){
            throw new RuntimeException("id przyszlo puste do metody doGet()");
        }
        Integer id = Integer.valueOf(req.getParameter("id")); //Tutaj juz rzuca bledem
        if(library.getProductById(id) != null){
            Product product = library.getProductById(id);
            req.setAttribute("product", product);
            if(req.getParameter("added") != null){
                req.setAttribute("added", Integer.valueOf(req.getParameter("added")));
            }
            req.getRequestDispatcher("product.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("product.jsp").forward(req, resp);
        //throw new RuntimeException("ProductServlet w metodzie get otrzymal zly parametr id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id")); //Gdyby nie bylo parametru "id" wyrzuciło by błąd już tutaj
        Integer amount = Integer.valueOf(req.getParameter("amount"));
        if(library.getProductById(id) == null){
            throw new RuntimeException("ProductServlet w metodzie post otrzymal zly parametr id");
        }
        //Tworzenie koszyka moze byc na stronie startowej
        if(req.getSession().getAttribute("cart") != null){
            //Koszyk juz istnieje
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.addProduct(id, amount);
            resp.sendRedirect("./product?id=" + id + "&added=" + amount);
        } else {
            //jesli koszyk nie istnieje to tworzymy nowy
            Cart cart = new Cart();
            req.getSession().setAttribute("cart", cart);
            cart.addProduct(id, amount);
            resp.sendRedirect("./product?id=" + id + "&added=" + amount);
        }
    }
}
