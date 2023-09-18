import screens.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();
        //testing.
        Screen mainScreen = new MainMenu("NameHereLol");
        mainScreen.addScreen(new AddSuperheroScreen("Add Superhero"));
        Screen addSuper2 = new AddSuperheroScreen("Add Superhero2");
        addSuper2.addScreen(new AddSuperheroScreen("Add super specific sub-menu"));
        mainScreen.addScreen(addSuper2);
        boolean run = true;
        while(run) {
            run = mainScreen.show();
        }

    }
}