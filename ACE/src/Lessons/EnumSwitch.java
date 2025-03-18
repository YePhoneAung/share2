package Lessons;
import java.util.Scanner;

public class EnumSwitch {
    
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a day: ");
        String d = scan.next().toUpperCase(); 
        boolean V = false;
        for (Day day : Day.values()) {
            if (day.name().equals(d)) {
                V = true;
                break;
            }
        }

        if (V) {
            Day day = Day.valueOf(d);
            switch (day) {
                case SUNDAY:
                    System.out.println("Sunday is a holiday");
                    break;
                case SATURDAY:
                    System.out.println("Saturday is best");
                    break;
                case MONDAY:
                    System.out.println("Monday is bad");
                    break;
                case TUESDAY:
                    System.out.println("Tuesday is not bad");
                    break;
                case WEDNESDAY:
                    System.out.println("Wednesday is not bad");
                    break;
                case THURSDAY:
                    System.out.println("Thursday is not bad");
                    break;
                case FRIDAY:
                    System.out.println("Friday is not bad");
                    break;
            }
        } else {
            System.out.println("Invalid input.");
        }

         
    }
}
		
