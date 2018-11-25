package io.ollg.store.servlet;

import io.ollg.store.model.Library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "library", urlPatterns = "/library")
public class LibraryServlet extends HttpServlet {

    private Library library = Library.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("library", library.getProducts());
        req.getRequestDispatcher("library.jsp").forward(req, resp);
    }

    public LibraryServlet() {
        populate();
    }
    private void populate(){
        library.addNewProduct("Lampka", 10000);
        library.addNewProduct("Krzeslo", 5000);
        library.addNewProduct("Stol", 20000);
    }
}
