package screens;

import dev.tolana.util.Input;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;


public class Screen {
    protected String name;
    private ArrayList<Screen> screens;
    private final Input input;

    public Screen(String name) {
        this.name = name;
        screens = new ArrayList<Screen>();
        input = new Input();
    }

    protected void end() {
        System.out.println("Any key to go BACK or EXIT.");
        input.inputString(": ");
    }

    public boolean show() throws Exception {
        if (!screens.isEmpty()) {
            boolean run = true;
            while (run) {
                Table table = new Table(name, new ArrayList<>(List.of("#", "Option")));
                int count = 1;
                for (Screen screen : screens) {
                    Row row = new Row();
                    //System.out.println(count + ". " + screen.getName());
                    row.addCell(""+count).addCell(screen.getName());
                    table.addRow(row);
                    count++;
                }
                table.addRow(new Row().addCell(""+0).addCell("To go BACK or EXIT"));
                System.out.println(table.getTableString());
                int choice = input.inputInt(": ");
                if (choice == 0) return false;
                screens.get(choice - 1).show();
            }
        } else {
            System.out.println("Press ANY key to go back or exit");
            input.inputString(": ");
            return false;
        }
        return false;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public String getName() {
        return name;
    }
}
