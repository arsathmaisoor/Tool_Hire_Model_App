package src;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Date date1 = DateUtil.convertStringToDate("13-03-2023");
        Date date2 = DateUtil.convertStringToDate("20-03-2023");

        // Calculate the number of days between the two dates using daysBetween() method
        long daysBetween = DateUtil.daysBetween(date1, date2);

        // Print the result to the console
        System.out.println("Number of days between " + DateUtil.convertDateToShortString(date1) + " and "
                + DateUtil.convertDateToShortString(date2) + " is: " + daysBetween);
    
    }
  }