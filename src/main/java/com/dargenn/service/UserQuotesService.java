package com.dargenn.service;

import com.dargenn.dao.UserQuotesDao;
import com.dargenn.model.UserQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Transactional
@Service("userQuotesService")
public class UserQuotesService {

    @Autowired
    private UserQuotesDao dao;

    public List<UserQuotes> findUserUserQuotes(int id){
        return dao.findUserQuotes(id);
    }

    public void addUserQuotes(UserQuotes userQuotes, int id){
        dao.addUserQuotes(userQuotes, id);
    }

    public void deleteUserQuotes(int id){
        dao.deleteUserQuotes(id);
    }
}
