package screens;

public class AddSuperheroScreen extends Screen {
    public AddSuperheroScreen(String name) {
        super(name);
    }

    @Override
    public boolean show() throws Exception {
        System.out.println("This is the bomb!");
        return super.show();
    }
}
