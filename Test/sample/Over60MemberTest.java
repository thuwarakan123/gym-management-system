package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class Over60MemberTest {
    final static Date date_3 = new Date(2012,12,11);
    final static Over60Member member_for_test_3= new Over60Member("Mathuravan",date_3,65);

    @Test
    public void setAge_testing() {
      int age =   67;
      member_for_test_3.setAge(age);
      int output = member_for_test_3.getAge();
      assertEquals(67,output);
      member_for_test_3.setAge(65);

    }

    @Test
    public void getAge_testing() {
        int output = member_for_test_3.getAge();
        assertEquals(65,output);

    }

    @Test
    public void getType_testing() {
        assertEquals("Over60 Member",member_for_test_3.getType());
    }
}