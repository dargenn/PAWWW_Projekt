package com.dargenn.dao;

import com.dargenn.model.UserClipboard;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Repository("userClipboardDao")
public class UserClipboardDao extends AbstractDao<Integer, UserClipboard> {

    @SuppressWarnings("unchecked")
    public List<UserClipboard> findUserClipboards(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<UserClipboard>) criteria.list();
    }

    public void addUserClipboard(UserClipboard userClipboard, int id){
        String q = "INSERT INTO UserClipboard(content, user_id) " +
                "VALUES(:content, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("content", userClipboard.getContent())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteUserClipboard(int id){
        String q = "DELETE FROM UserClipboard WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
