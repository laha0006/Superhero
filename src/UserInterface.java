
public class UserInterface {
    private final Input input;
    private final Database DB;


    public UserInterface() {
        input = new Input();
        DB = new Database();
    }

    public void start() {
        boolean run = true;
        while (run) {
            run = menu();
        }
        System.exit(0);


    }





    public boolean menu() {
        System.out.println("1. add superhero");
        System.out.println("2. Show Database");
        System.out.println("3. Search Database");
        System.out.println("9. exit");
        int choice = input.inputInt(": ");
        return switch (choice) {
            case 1 -> {
                inputSuperhero();
                yield true;
            }
            case 2 -> {
                System.out.println(DB);
                yield true;
            }
            case 3 -> {
                searchScreen();
                yield true;
            }
            case 9 -> false;
            default -> {
                //System.exit(1337);
                System.out.println("input number from the menu.");
                yield true;
            }
        };
    }

    public void searchScreen() {
        String searchTerm = input.inputString("Search: ");
        Superhero sh = DB.search(searchTerm);
        if (sh != null) {
            System.out.println(sh);
        } else {
            System.out.println("None found.");
        }
    }

    public void inputSuperhero() {
        boolean isHuman;
        String name = input.inputString("Superhero name: ");
        String realName = input.inputString("Real name: ");
        String superPower = input.inputString("Superpower: ");
        char isHumanYesNo = input.inputChar("Is Human? (y/n): ");
        switch (isHumanYesNo) {
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

        DB.addSuperhero(new Superhero(name, realName, isHuman, superPower, yearCreated, strength));


    }

}
