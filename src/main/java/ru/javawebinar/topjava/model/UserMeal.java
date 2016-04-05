package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "UserMeal.delete", query = "DELETE from UserMeal um WHERE um.id=:id AND um.user.id=:userId"),
        @NamedQuery(name = "UserMeal.getAll", query = "SELECT um from UserMeal um WHERE um.user.id=:userId " +
                "ORDER BY um.dateTime DESC"),
        @NamedQuery(name = "UserMeal.getBetween", query = "SELECT um from UserMeal um WHERE um.user.id=:userId " +
                "AND um.dateTime BETWEEN :startDate AND :endDate ORDER BY um.dateTime DESC")
})
@Entity
@Table(name = "meals")
public class UserMeal extends BaseEntity {

    @Column(name = "date_time", columnDefinition = "default timestamp now()")
    private LocalDateTime dateTime;

    @Column(name = "description")
    private String description;

    @Column(name = "calories", nullable = false)
    @NotEmpty
    protected int calories;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public UserMeal() {
    }

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
