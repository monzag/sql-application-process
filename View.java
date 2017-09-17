import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class View {

    public void displayMenu() {
        ArrayList<String> options = new ArrayList<>(Arrays.asList("Display mentors by full name", "Display mentors by city",
                                                                  "Add full_name to Applicant Carol", "Add full_name by email",
                                                                  "Add new Applicant", "Update applicant's phone'", "Delete applicant"));

        displayOptions(options);
        System.out.println("\n0. Exit");
    }
 
    public void displayOptions(ArrayList<String> options) {
        Integer number = 1;
        System.out.println(" ");
        for (String option : options) {
            System.out.println(String.format("%d. %s", number, option));
            number++;
        }
    }

    public int getUserChoice() {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.println("Enter a number: ");
        while (!input.hasNextInt()) {
            printErrorMessage();
            input.next();
        }

        number = input.nextInt();
        return number;
    }

    public void printErrorMessage() {
        System.out.println("Error!");
    }
}