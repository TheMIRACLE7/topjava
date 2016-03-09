package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

public interface MealRepository {
    void create(UserMeal userMeal);
    UserMeal get(int id);
    List<UserMeal> getAll();
    void upd(UserMeal userMeal);
    void del(int id);
}
