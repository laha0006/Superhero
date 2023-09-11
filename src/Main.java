import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

//        String test = input.inputString("Test: ", "Test skal skrives!");
//        System.out.println(test);
//        char test2 = input.inputChar("Char: ");
//        System.out.println("test2 = " + test2);
        int test3 = input.inputInt("Strength: ");
        System.out.println("test3 = " + test3);

    }
}