package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    final static Date date_4 = new Date(2015,5,23);

    @Test
    public void getDate_testing() {
        String output = "23/5/2015";
        assertEquals(output,date_4.getDate());
    }
}