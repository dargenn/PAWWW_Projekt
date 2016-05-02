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
    public void saveExcercise(Excercise excercise){
        persist(excercise);
    }

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
}
