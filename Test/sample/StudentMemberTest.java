package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMemberTest {
     final static Date date_2 = new Date(2012,12,11);
     final static StudentMember member_for_test_2= new StudentMember("Mathuravan",date_2);

    @Test
    public void setSchoolName_testing() {
        String school_name = "Hindu college";
        member_for_test_2.setSchoolName(school_name);
        assertEquals(school_name,member_for_test_2.getSchoolName());
    }

    @Test
    public void getSchoolName_testing() {
        assertEquals("Hindu college",member_for_test_2.getSchoolName());
    }

    @Test
    public void getType() {
        assertEquals("Student Member",member_for_test_2.getType());
    }
}