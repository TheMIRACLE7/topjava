package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRepoImpl implements MealRepository {
    private static InMemoryRepoImpl impl;
    private ConcurrentMap<Integer, UserMeal> data = new ConcurrentHashMap<>();

    private static AtomicInteger id = new AtomicInteger(0);

    public static InMemoryRepoImpl getImpl() {
        if (impl == null) {
            impl = new InMemoryRepoImpl();
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
            impl.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
        }
        return impl;
    }

    public void create(UserMeal userMeal) {
        userMeal.setId(id.getAndIncrement());
        data.put(userMeal.getId(), userMeal);
    }

    public List<UserMeal> getAll() {
        return new ArrayList<>(data.values());
    }

    public UserMeal get(int id) {
        return data.get(id);
    }

    public void upd(UserMeal userMeal) {
        data.replace(userMeal.getId(), userMeal);
    }

    public void del(int id) {
        data.remove(id);
    }
}
