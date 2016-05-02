package com.dargenn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by dargenn on 4/26/16.
 */
@Entity
public class Excercise {
    private int id;
    private String name;
    private Integer sets;
    private Integer reps;
    private Integer weight;
    private Timestamp excerciseDate;
    private int user_id;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sets")
    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    @Basic
    @Column(name = "reps")
    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "excercise_date")
    public Timestamp getExcerciseDate() {
        return excerciseDate;
    }

    public void setExcerciseDate(Timestamp excerciseDate) {
        this.excerciseDate = excerciseDate;
    }

    @Basic
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excercise excercise = (Excercise) o;

        if (id != excercise.id) return false;
        if (name != null ? !name.equals(excercise.name) : excercise.name != null) return false;
        if (sets != null ? !sets.equals(excercise.sets) : excercise.sets != null) return false;
        if (reps != null ? !reps.equals(excercise.reps) : excercise.reps != null) return false;
        if (weight != null ? !weight.equals(excercise.weight) : excercise.weight != null) return false;
        if (excerciseDate != null ? !excerciseDate.equals(excercise.excerciseDate) : excercise.excerciseDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sets != null ? sets.hashCode() : 0);
        result = 31 * result + (reps != null ? reps.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (excerciseDate != null ? excerciseDate.hashCode() : 0);
        return result;
    }
}
