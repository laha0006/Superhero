package screens;

import dev.tolana.util.Input;
import superhero.Database;
import superhero.Superhero;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;

public class SearchSuphero extends Screen{
    Database db;
    Input input = new Input();
    public SearchSuphero(String name,Database db) {
        super(name);
        this.db = db;
    }

    public void searchSuperhero() throws Exception {
        boolean searching = true;
        while(searching) {
            System.out.println("0 to EXIT");
            String searchTerm = input.inputString("Search: ");
            try {
                if(Integer.parseInt(searchTerm) == 0) {
                    return;
                }
            } catch (Exception ignored) {}


            Superhero sh = db.search(searchTerm);
            if (sh != null) {
                Table table = new Table(sh.getName(),
                        new ArrayList<>(List.of("Superhero Name", " Real Name", "Human?", "Superpower", "Strength", "Year created")));
                table.addRow(new Row().addCell(sh.getName())
                        .addCell(sh.getRealName())
                        .addCell(sh.isHuman())
                        .addCell(sh.getSuperPower())
                        .addCell(sh.getStrength())
                        .addCell(sh.getCreationYear()));

                System.out.println(table.getTableString());
                searching = false;
                System.out.println("Press ENTER to EXIT");
                input.inputString(": ");
            } else {
                System.out.println("None found.");
            }
        }
    }
    @Override
    public boolean show() throws Exception {
        searchSuperhero();
        return false;
    }
}
