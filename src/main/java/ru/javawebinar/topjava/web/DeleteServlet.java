package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.repository.InMemoryRepoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InMemoryRepoImpl.getImpl().del(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("meals");
    }
}
