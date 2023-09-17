package screens;

import java.util.ArrayList;

public class Screen {
    protected String name;
    private ArrayList<Screen> screens;

    public Screen(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println(name);
    }
}
