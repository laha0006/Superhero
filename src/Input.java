import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputString(String prompt, String errMsg) {
        String output = "";
        System.out.print(prompt);

        try {
            output = scanner.nextLine();
            return output;
        } catch (NoSuchElementException e) {
            System.out.println(errMsg);
            return output;
        }
    }

    public char inputChar(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return scanner.next().charAt(0);
            } catch (Exception e) {
                return '?';

            }
        }
    }

    public int inputInt(String prompt) {

        while(true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Must be number!");
                scanner.next();
            }
        }
    }
}
