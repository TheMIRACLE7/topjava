package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.InMemoryRepoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserMeal userMeal = new UserMeal(LocalDateTime.parse(request.getParameter("date")),
                request.getParameter("description"), Integer.parseInt(request.getParameter("calories")));
        userMeal.setId(Integer.parseInt(request.getParameter("id")));
        InMemoryRepoImpl.getImpl().upd(userMeal);
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("meal", InMemoryRepoImpl.getImpl().get(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
