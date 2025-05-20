import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void testNormalDay(){
        assertEquals("02/03/2014", NextDayCalculator.findNextDay(1,3,2014));
    }

    @Test
    void testEndOfMonth(){
        assertEquals("01/07/2025", NextDayCalculator.findNextDay(30,6,2025));
    }

    @Test
    void testEndOfYear(){
        assertEquals("01/01/2026", NextDayCalculator.findNextDay(31,12,2025));
    }

    @Test
    void testLeapYear(){
        assertEquals("29/02/2024", NextDayCalculator.findNextDay(28, 2, 2024));
    }

    @Test
    void testLeapYearEndOfFebruary() {
        assertEquals("01/03/2024", NextDayCalculator.findNextDay(29, 2, 2024));
    }

    @Test
    void testNonLeapYearEndOfFebruary() {
        assertEquals("01/03/2025", NextDayCalculator.findNextDay(28, 2, 2025));
    }
}