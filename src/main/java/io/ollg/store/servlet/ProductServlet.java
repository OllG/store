package io.ollg.store.servlet;

import io.ollg.store.model.Library;
import io.ollg.store.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "product", urlPatterns = "product")
public class ProductServlet extends HttpServlet {

    private Library library = Library.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Product product = library.getProductById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }
}
