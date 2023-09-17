package screens;

public class MainMenu extends Screen {

    public MainMenu(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("This is the " + name + " screen!");
        testScreen();
    }

    public String getName() {
        return name;
    }

    private void testScreen() {
        System.out.println("Testing Tested Testest");
    }
}
