package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultMemberTest {
    final static Date date_1 = new Date(2012,12,11);
    final static DefaultMember member_for_test = new DefaultMember("Thuwarakan",date_1);


    @Test
    public void setMemberName_testing() {

        String new_name = "jeyakumar";
        member_for_test.setMemberName(new_name);
        assertEquals(new_name , member_for_test.getMemberName());

    }

    @Test
    public void getMemberName_testing() {
        assertEquals("Thuwarakan" , member_for_test.getMemberName());
    }

    @Test
    public void getMembershipNumber_testing() {
        assertEquals(1001, member_for_test.getMembershipNumber());
    }

    @Test
    public void getType_testing() {
        assertEquals("Default Member",member_for_test.getType());
    }

    @Test
    public void getInformation_testing() {
        String new_test = String.format("%6s %18s %15s %18s","1001","Thuwarakan","11/12/2012","Default Member");
        assertEquals( new_test, member_for_test.getInformation() );

    }

    @Test
    public void writeFile_testing() {
        String test_file = "Name = "+"Thuwarakan"+"\nMembershipNumber = "+"1001"+"\nStart Date = "+"11/12/2012"
                +"\nType = "+"Default Member";
        assertEquals(test_file,member_for_test.writeFile());
    }


}