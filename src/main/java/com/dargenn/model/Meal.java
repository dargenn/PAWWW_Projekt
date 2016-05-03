package com.dargenn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by dargenn on 4/26/16.
 */
@Entity
public class Meal {
    private int id;
    private String name;
    private String amount;
    private String type;
    private Timestamp mealDate;
    private int user_id;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "meal_date")
    public Timestamp getMealDate() {
        return mealDate;
    }

    public void setMealDate(Timestamp mealDate) {
        this.mealDate = mealDate;
    }

    @Basic
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (id != meal.id) return false;
        if (name != null ? !name.equals(meal.name) : meal.name != null) return false;
        if (amount != null ? !amount.equals(meal.amount) : meal.amount != null) return false;
        if (type != null ? !type.equals(meal.type) : meal.type != null) return false;
        if (mealDate != null ? !mealDate.equals(meal.mealDate) : meal.mealDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (mealDate != null ? mealDate.hashCode() : 0);
        return result;
    }
}
