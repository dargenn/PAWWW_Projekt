package com.dargenn.service;

import com.dargenn.dao.UserClipboardDao;
import com.dargenn.model.UserClipboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Service("userClipboardService")
@Transactional
public class UserClipboardService {
    @Autowired
    private UserClipboardDao dao;

    public List<UserClipboard> findUserUserClipboards(int id){
        return dao.findUserClipboards(id);
    }

    public void addUserClipboard(UserClipboard userClipboard, int id){
        dao.addUserClipboard(userClipboard, id);
    }

    public void deleteUserClipboard(int id){
        dao.deleteUserClipboard(id);
    }
}
