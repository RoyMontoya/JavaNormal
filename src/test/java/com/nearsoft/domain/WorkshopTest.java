package com.nearsoft.domain;

import com.nearsoft.exception.WorkshopGroupIsFullException;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class WorkshopTest {

    @Test
    public void workshopGroupCanBeOpenedIfEnrolledStudentsAreMoreThanMin() throws Exception {
        Workshop java = new Workshop("Java Advanced", 3,1, new Date());
        assertFalse(java.canBeOpened());
        java.enroll(new Student("John", "Doe", "foo@doe.com"));
        assertTrue(java.canBeOpened());
    }

    @Test(expected = WorkshopGroupIsFullException.class)
    public void workshopCanNotHaveMoreThanMaxStudents() throws Exception{

        Workshop java = new Workshop("Java super advanced", 1,1, new Date());
        java.enroll(new Student("John", "Doe", "foo@doe.com"));
        java.enroll(new Student("Lisa", "Unlucky", "luck@unlucky.com"));
    }
}