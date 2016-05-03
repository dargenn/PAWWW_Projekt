package com.dargenn.dao;

import com.dargenn.model.UserQuotes;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Repository("userQuotesDao")
public class UserQuotesDao extends AbstractDao<Integer, UserQuotes> {

    @SuppressWarnings("unchecked")
    public List<UserQuotes> findUserQuotes(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<UserQuotes>) criteria.list();
    }

    public void addUserQuotes(UserQuotes userQuotes, int id){
        String q = "INSERT INTO User_Quotes(content, user_id) " +
                "VALUES(:content, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("content", userQuotes.getContent())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteUserQuotes(int id){
        String q = "DELETE FROM User_Quotes WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
