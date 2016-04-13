package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository{

    @Autowired
    private ProxyUserMealRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        userMeal.setUser(userProxy.getOne(userId));
        if (!userMeal.isNew() && get(userMeal.getId(), userId) == null) {
            return null;
        }
        return proxy.save(userMeal);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxy.delete(id, userId) != 0;
//        return false;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return proxy.get(id, userId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return proxy.findAll(userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return proxy.findBetween(userId, startDate, endDate);
    }
}