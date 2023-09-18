package superhero;

import dev.tolana.util.Input;
import screens.*;

public class UserInterface {
    private final Input input;
    private final Database db;

    public UserInterface() {
        input = new Input();
        db = new Database();
    }

    public void start() throws Exception {
        Screen mainScreen = new MainMenu("Superhero Database");
        Screen addSuperhero = new AddSuperhero("Add Superhero",db);
        Screen editSupehero = new EditSuperheroMenu("Edit Superhero",db);
        Screen showDatabase = new ShowDatabase("Show Database",db);
        Screen searchDatabase = new SearchSuphero("Search Database",db);
        mainScreen.addScreen(showDatabase);
        mainScreen.addScreen(addSuperhero);
        mainScreen.addScreen(searchDatabase);
        mainScreen.addScreen(editSupehero);
        boolean run = true;
        while(run) {
            run = mainScreen.show();
        }
    }
}
