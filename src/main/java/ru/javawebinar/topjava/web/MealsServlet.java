package ru.javawebinar.topjava.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.repository.InMemoryRepoImpl;
import ru.javawebinar.topjava.util.UserMealsUtil;

public class MealsServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealsServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<UserMealWithExceed> userMealsWithExceeded = UserMealsUtil.getFilteredMealsWithExceeded(
                InMemoryRepoImpl.getImpl().getAll(), LocalTime.of(7, 0), LocalTime.of(23, 0), 2000);

        if (userMealsWithExceeded.isEmpty()) response.sendRedirect("emptyList.jsp");
        else {
            request.setAttribute("userMealsWithExceeded", userMealsWithExceeded);
            request.getRequestDispatcher("mealList.jsp").forward(request, response);
        }
    }
}
