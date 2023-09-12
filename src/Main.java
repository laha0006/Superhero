import java.util.Scanner;

public class Main {
    public static Input input = new Input();
    public static Database DB = new Database();
    public static void main(String[] args) {


        while(true) {
            menu();
        }



    }

    public static void menu() {
        System.out.println("1. add superhero");
        System.out.println("2. Show Database");
        System.out.println("9. exit");
        int choice = input.inputInt(": ");
        switch(choice) {
            case 1:
                inputSuperhero();
                break;
            case 2:
                System.out.println(DB);
                break;
            case 9:
                System.exit(1);
                break;
            default:
                System.exit(1);
                break;
        }
    }

    public static void inputSuperhero() {
        boolean isHuman;
        String name = input.inputString("Superhero name: ");
        String realName = input.inputString("Real name: ");
        String superPower = input.inputString("Superpower: ");
        char isHumanYesNo = input.inputChar("Is Human? (y/n): ");
        switch(isHumanYesNo) {
            case 'y':
                isHuman = true;
                break;
            case 'n':
                isHuman = false;
                break;
            default:
                isHuman = true;
                break;
        }
        int strength = input.inputInt("Strength: ");
        int yearCreated = input.inputInt("Year Created: ");

        DB.addSuphero(name,realName,isHuman,superPower,yearCreated,strength);


    }
}