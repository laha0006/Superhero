package screens;

import dev.tolana.util.Input;
import superhero.Database;
import superhero.Superhero;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteScreen extends Screen{
    Input input = new Input();
    Database db;
    public DeleteScreen(String name,Database db) {
        super(name);
        this.db = db;
    }

    public void deleteSuperhero() throws Exception {
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
                System.out.println("Type DELETE to DELETE or Press ENTER to EXIT");
                String choice = input.inputString(": ");
                System.out.println("db.getSuperheroList().indexOf(sh) = " + db.getSuperheroList().indexOf(sh));
                if(Objects.equals(choice, "DELETE")) db.delete(db.getSuperheroList().indexOf(sh));


            } else {
                System.out.println("None found.");
            }
        }
    }

    @Override
    public boolean show() throws Exception {
        deleteSuperhero();
        return false;
    }
}
