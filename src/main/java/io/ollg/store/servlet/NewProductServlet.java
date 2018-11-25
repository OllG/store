package io.ollg.store.servlet;

import io.ollg.store.model.Library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createNewProduct", urlPatterns = "/createNewProduct")
public class NewProductServlet extends HttpServlet {
    Library library = Library.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("createNewProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double inputPrice = Double.valueOf((Double.valueOf(req.getParameter("price"))));
        int newPrice = (int)((inputPrice * 100) + 0.5);

        Integer newId = library.addNewProduct(name, newPrice);
        resp.sendRedirect("./product?id=" + newId);
    }
}
