package com.dargenn.service;

import com.dargenn.dao.SuplementDao;
import com.dargenn.model.Suplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dargenn on 5/3/16.
 */
@Service("suplementService")
@Transactional
public class SuplementService {
    @Autowired
    private SuplementDao dao;

    public List<Suplements> findUserSuplements(int id){
        return dao.findUserSuplements(id);
    }

    public void addSuplement(Suplements suplements, int id){
        dao.addSuplement(suplements, id);
    }

    public void deleteSuplement(int id){
        dao.deleteSuplement(id);
    }
}
