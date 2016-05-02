package com.dargenn.dao;

import com.dargenn.model.Excercise;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 5/2/16.
 */
@Repository("excerciseDao")
public class ExcerciseDao extends AbstractDao<Integer, Excercise> {

    @SuppressWarnings("unckecked")
    public List<Excercise> findUserExcercises(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Excercise>) criteria.list();
//        String q = "SELECT name, sets, reps, weight, excercise_date " +
//                    "FROM Excercise WHERE user_id = :userid";
//        List result = getSession().createSQLQuery(q)
//                .setParameter("userid", id).list();
//        return (List<Excercise>) result;
    }

    public void addExcercise(Excercise excercise, int id){
        String q = "INSERT INTO Excercise(name, sets, reps, weight, user_id) " +
                "VALUES(:name, :sets, :reps, :weight, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", excercise.getName())
                .setParameter("sets", excercise.getSets())
                .setParameter("reps", excercise.getReps())
                .setParameter("weight", excercise.getWeight())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void editExcercise(Excercise excercise, int id){
        String q = "UPDATE Excercise " +
                "SET name = :name, sets = :sets, reps = :reps, weight = :weight " +
                "WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("name", excercise.getName())
                .setParameter("sets", excercise.getSets())
                .setParameter("reps", excercise.getReps())
                .setParameter("weight", excercise.getWeight())
                .setParameter("id", id)
                .executeUpdate();
    }
}
