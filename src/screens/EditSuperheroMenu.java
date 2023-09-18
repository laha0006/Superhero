package screens;

import dev.tolana.util.Input;
import superhero.Database;
import superhero.Superhero;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;

public class EditSuperheroMenu extends Screen{
    Input input;
    Database db;
    public EditSuperheroMenu(String name, Database db) {
        super(name);
        input = new Input();
        this.db = db;
    }

    public boolean editSuperhero(Superhero superhero) throws Exception {
        Table table = new Table("Edit " + superhero.getName(),
                new ArrayList<>(List.of("Superhero Name"," Real Name","Human?","Superpower","Strength","Year created")));
        table.addRow(new Row().addCell(superhero.getName())
                .addCell(superhero.getRealName())
                .addCell(superhero.isHuman())
                .addCell(superhero.getSuperPower())
                .addCell(superhero.getStrength())
                .addCell(superhero.getCreationYear()));
        //System.out.println("Edit: " + superhero.getName());
        System.out.println(table.getTableString());
        System.out.println("Press ENTER to Edit, 9 to go back to selection/exit");
        String back = input.inputString(":");
        if (!back.isEmpty()) {
            return true;
        }
        System.out.println("Press Enter for no change.");
        System.out.println("Name: " + superhero.getName());
        String newName = input.inputString(": ");
        if (!newName.isEmpty()) superhero.setName(newName);

        System.out.println("Real Name: " + superhero.getRealName());
        String newRealName = input.inputString(": ");
        if (!newName.isEmpty()) superhero.setRealName(newRealName);

        System.out.println(superhero.getName() + " is " + (superhero.isHuman() ? "Human" : "not Human"));
        char choice = input.inputChar("Change human status? (y)/(n)");
        if (choice == 'y') {
            superhero.setHuman(!superhero.isHuman());
        }

        System.out.println("Superpower: " + superhero.getSuperPower());
        String newSuperPowqer = input.inputString(": ");
        if (!newSuperPowqer.isEmpty()) superhero.setSuperPower(newSuperPowqer);

        System.out.println("Strength: " + superhero.getStrength());
        String newStrength = input.inputString(": ");
        if (!newStrength.isEmpty()) superhero.setStrength(Integer.parseInt(newStrength));

        System.out.println("Creation Year: " + superhero.getCreationYear());
        String newCreationYear = input.inputString(": ");
        if (!newCreationYear.isEmpty()) superhero.setCreationYear(Integer.parseInt(newCreationYear));
        return false;
    }
    public void editMenu() throws Exception {
        System.out.println("Search by superhero.Superhero name.");
        String searchTerm = input.inputString("Search: ");
        ArrayList<Superhero> result = db.searchMany(searchTerm);
        boolean run = true;
        while (run) {
            int count = 1;
            if (!result.isEmpty()) {
                if (result.size() == 1) {
                    editSuperhero(result.get(0));
                    run = false;
                } else {
                    Table table = new Table("Search Results",
                            new ArrayList<>(List.of("#","Superhero")));
                    for (Superhero superhero : result) {
                        //System.out.println(count++ + ". " + superhero.getName());
                        table.addRow(new Row().addCell("" + count++).addCell(superhero.getName()));
                    }
                    System.out.println(table.getTableString());
                    System.out.println("Select superhero to EDIT. 0 to exit.");
                    int choice = input.inputInt(": ");
                    if(choice == 0) run = false;
                    if (choice <= result.size() && choice > 0) {
                        run = editSuperhero(result.get(choice - 1));
                    } else {
                        run = false;
                    }
                }
            } else {
                System.out.println("None Found.");
                run = false;
            }
        }
    }
    @Override
    public boolean show() throws Exception {
        editMenu();
        return false;
    }
}
