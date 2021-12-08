package base;

import java.time.LocalDate;
import java.time.Month;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int monthValue = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        System.out.println(monthValue);
        System.out.println(dayOfMonth);
    }
}
