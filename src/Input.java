import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputString(String prompt) {
        String output = "";
        System.out.print(prompt);

        try {
            //scanner.nextLine();
            output = scanner.nextLine();
            return output;
        } catch (NoSuchElementException e) {
            return output;
        }
    }

    public char inputChar(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                char value = scanner.next().charAt(0);
                scanner.nextLine();
                return value;
            } catch (Exception e) {

                return '?';
            }
        }
    }

    public int inputInt(String prompt) {

        while (true) {
            try {

                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Must be number!");
                scanner.nextLine();
            }
        }
    }
}
