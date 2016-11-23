package com.johnremboo.timetest;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeManagerTest {

    @Test
    public void timeValidation() {
        for (int i = 0; i < 24; i++) {
            boolean value = TimeManager.isTimeValid(i);
            assertEquals(true, value);
        }
    }

    @Test
    public void getTimeNameTest() {
        for (int i = 0; i < 24; i++) {
            String value = TimeManager.getTimeName(i);

            if (i >= 6 && i < 9) {
                assertEquals(TimeManager.Time.MORNING.toString().toLowerCase(), value);
            } else if (i >= 9 && i < 19) {
                assertEquals(TimeManager.Time.DAY.toString().toLowerCase(), value);
            } else if (i >= 19 && i < 23) {
                assertEquals(TimeManager.Time.EVENING.toString().toLowerCase(), value);
            } else {
                assertEquals(TimeManager.Time.NIGHT.toString().toLowerCase(), value);
            }
        }
    }
}
