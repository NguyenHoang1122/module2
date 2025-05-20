public class NextDayCalculator {
    public static String findNextDay(int day, int month, int year) {
        int[] dayIsMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            dayIsMonth[1] = 29;
        }
        day++;
        if(day > dayIsMonth[month-1]) {
            day = 1;
            month++;
            if(month > 12) {
                month = 1;
                year++;
            }
        }
        return String.format("%02d/%02d/%04d", day, month, year);
    }
    private static boolean isLeapYear ( int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
