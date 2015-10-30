package com.nearsoft.domain;

import com.nearsoft.exception.WorkshopGroupIsFullException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Workshop {

    private String title;
    private int maxGroupSize;
    private int minGroupSize;
    private Date startDate;
    private List<Student> students = new ArrayList<Student>();

    public Workshop(String title, int maxGroupSize, int minGroupSize, Date startDate){
            this.title = title;
            this.maxGroupSize = maxGroupSize;
            this.minGroupSize = minGroupSize;

    }

    public boolean canBeOpened(){
        return students.size() >= getMinGroupSize();
    }

    public boolean canBeEnrolled(){
        return students.size() < getMaxGroupSize();
    }

    public void enroll(Student student) {
        if(canBeEnrolled()){
            students.add(student);
        }else{
            throw new WorkshopGroupIsFullException();
        }

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public int getMinGroupSize() {
        return minGroupSize;
    }

    public void setMinGroupSize(int minGroupSize) {
        this.minGroupSize = minGroupSize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
