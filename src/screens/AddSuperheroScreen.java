package screens;

public class AddSuperheroScreen extends Screen {


    public AddSuperheroScreen(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("This is the + "+ this.name + " screens.Screen");
    }

    public String getName() {
        return name;
    }
}
