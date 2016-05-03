package com.dargenn.dao;

import com.dargenn.model.Meal;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Repository("mealDao")
public class MealDao extends AbstractDao<Integer, Meal> {

    @SuppressWarnings("unchecked")
    public List<Meal> findUserMeals(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Meal>) criteria.list();
    }

    public void addMeal(Meal meal, int id){
        String q = "INSERT INTO Meal(name, amount, type, user_id) " +
                "VALUES(:name, :amount, :type, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", meal.getName())
                .setParameter("amount", meal.getAmount())
                .setParameter("type", meal.getType())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteMeal(int id){
        String q = "DELETE FROM Meal WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
