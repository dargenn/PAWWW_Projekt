package com.dargenn.dao;

import com.dargenn.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dargenn on 4/26/16.
 */

@Repository("userDao")
public class UserDao extends AbstractDao<Integer, User>{

    public User findById(int id){
        return getByKey(id);
    }

    public void saveUser(User user){
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers(){
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public int getUserCount(){
        Query query = getSession().getNamedQuery("userCount");
        return Integer.parseInt(query.uniqueResult().toString());
    }
}
