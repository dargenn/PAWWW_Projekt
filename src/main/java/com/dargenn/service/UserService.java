package com.dargenn.service;

import com.dargenn.dao.UserDao;
import com.dargenn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dargenn on 4/26/16.
 */
@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao dao;

    public User findById(int id){
        return dao.findById(id);
    }

    public void saveUser(User user){
        dao.saveUser(user);
    }

    public void updateUser(User user){
        User entity = dao.findById(user.getId());
        if(entity != null){
            entity.setId(user.getId());
            entity.setLogin(user.getLogin());
            entity.setPassword(user.getPassword());
        }
    }

    public List<User> findAllUsers(){
        return dao.findAllUsers();
    }

    public int getUserCount(){
        return dao.getUserCount();
    }

    public boolean validateUser(String username, String password)
    throws NoSuchAlgorithmException {
        return dao.validateUser(username, password);
    }

    public boolean isUsernameUnique(String username) {
        return dao.isUsernameUnique(username);
    }

    public void addUser(User user){
        dao.addUser(user);
    }

    public int findUserByLogin(String username){
        return dao.findUserByLogin(username);
    }
}
