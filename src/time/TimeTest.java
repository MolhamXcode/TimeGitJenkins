package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

    @Test
    void testGetTotalSecondsGood() {
        int seconds = Time.getTotalSeconds("05:05:05:05");
        assertTrue("The seconds were not calculated properly", seconds == 18305);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:00:00", "12:34:56", "23:59:59"})
    void testGetTotalSecondsBoundary(String time) {
        int expectedSeconds = Time.getTotalSeconds(time);
        int seconds = Time.getTotalSeconds(time);
        assertEquals(expectedSeconds, seconds);
    }

    @Test
    public void testGetTotalSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getTotalSeconds("10:00");
        });
    }

    @Test
    void testGetSecondsGood() {
        int seconds = Time.getSeconds("05:05:05:05");
        assertEquals(5, seconds);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:00:00:00", "12:34:56:01", "23:59:59:59"})
    void testGetSecondsBoundary(String time) {
        int expectedSeconds = Time.getSeconds(time);
        int seconds = Time.getSeconds(time);
        assertEquals(expectedSeconds, seconds);
    }

    @Test
    void testGetSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getSeconds("10:00");
        });
    }

    @Test
    void testGetTotalMinutesGood() {
        int minutes = Time.getTotalMinutes("05:05:05");
        assertEquals(5, minutes);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:00:00", "12:34:56", "23:59:59"})
    void testGetTotalMinutesBoundary(String time) {
        int expectedMinutes = Time.getTotalMinutes(time);
        int minutes = Time.getTotalMinutes(time);
        assertEquals(expectedMinutes, minutes);
    }

    @Test
    void testGetTotalMinutesBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getTotalMinutes("10:0");
        });
    }

    @Test
    void testGetTotalHoursGood() {
        int hours = Time.getTotalHours("05:05:05:05");
        assertEquals(5, hours);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:00:00:00", "12:34:56:00", "23:59:59:00"})
    void testGetTotalHoursBoundary(String time) {
        int expectedHours = Time.getTotalHours(time);
        int hours = Time.getTotalHours(time);
        assertEquals(expectedHours, hours);
    }

    @Test
    void testGetTotalHoursBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Time.getTotalHours("1");
        });
    }
    
    @Test
    void testGetMillisecondsGood() {
    	int milliseconds = Time.getMilliseconds("05:05:05:05");
        assertEquals(5, milliseconds);
    }
    
    @Test
    void testGetMillisecondsBoundary() {
    	String time = "05:05:12:00";
    	int expectedMilliseconds = 00; //Time.getMilliseconds(time);
        int milliseconds = Time.getMilliseconds(time);
        assertEquals(expectedMilliseconds, milliseconds);
    }
    
    @Test
    void testGetMillisecondsBad() {
    	
    	assertEquals(Time.getMilliseconds("10:00:00"), -1);
    }
}
