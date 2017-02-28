package java8_features;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * With Java 8, a new Date-Time API is introduced
 * to cover the following drawbacks of old date-time API:
 * Not thread safe
 * Poor design
 * Difficult time zone handling
 *
 * Created by nector on 28/02/17.
 */
public class NewDateTimeAPI {

    public static void main(String args[]) {
        NewDateTimeAPI java8tester = new NewDateTimeAPI();
        java8tester.testLocalDateTime();
    }

    public void testLocalDateTime() {

        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date 1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month + "; day: " + day + "; seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date 2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date 3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date 4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date 5: " + date5);
    }

}
