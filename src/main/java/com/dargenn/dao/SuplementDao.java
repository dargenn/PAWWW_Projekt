package com.dargenn.dao;

import com.dargenn.model.Suplements;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Repository("suplementDao")
public class SuplementDao extends AbstractDao<Integer, Suplements> {

    @SuppressWarnings("unchecked")
    public List<Suplements> findUserSuplements(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Suplements>) criteria.list();
    }

    public void addSuplement(Suplements suplements, int id){
        String q = "INSERT INTO Suplements(name, amount, user_id) " +
                "VALUES(:name, :amount, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", suplements.getName())
                .setParameter("amount", suplements.getAmount())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteSuplement(int id){
        String q = "DELETE FROM Suplements WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
