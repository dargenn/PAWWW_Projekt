package com.dargenn.service;

import com.dargenn.dao.ExcerciseDao;
import com.dargenn.model.Excercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dargenn on 5/2/16.
 */
@Service("excerciseService")
@Transactional
public class ExcerciseService {

    @Autowired
    private ExcerciseDao dao;

    public void saveExcercise(Excercise excercise){
        dao.saveExcercise(excercise);
    }

    public List<Excercise> findUserExcercises(int id){
        return dao.findUserExcercises(id);
    }
}
