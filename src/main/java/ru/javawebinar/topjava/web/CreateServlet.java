package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.InMemoryRepoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class CreateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("createMeal.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        try {
            LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
            String description = request.getParameter("description");
            int calories = Integer.parseInt(request.getParameter("calories"));
            InMemoryRepoImpl.getImpl().create(new UserMeal(date, description, calories));
            response.sendRedirect("meals");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
