package screens;

import dev.tolana.util.Input;
import superhero.Database;
import superhero.Superhero;

public class AddSuperhero extends Screen {
    Input input = new Input();
    Database db;
    public AddSuperhero(String name, Database db) {
        super(name);
        this.db = db;
    }

    public void inputSuperhero() {
        boolean isHuman;
        String name = input.inputString("superhero.Superhero name>");
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

        db.addSuperhero(new Superhero(name, realName, isHuman, superPower, yearCreated, strength));


    }
    @Override
    public boolean show() throws Exception {
        inputSuperhero();
        return false;
    }
}
