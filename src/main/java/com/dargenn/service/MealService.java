package com.dargenn.service;

import com.dargenn.dao.MealDao;
import com.dargenn.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Service("mealService")
@Transactional
public class MealService {
    @Autowired
    private MealDao dao;

    public List<Meal> findUserMeals(int id){
        return dao.findUserMeals(id);
    }

    public void addMeal(Meal Meal, int id){
        dao.addMeal(Meal, id);
    }

    public void deleteMeal(int id){
        dao.deleteMeal(id);
    }
}
