package screens;

import superhero.Database;
import superhero.Superhero;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;

public class ShowDatabase extends Screen{
    Database db;
    public ShowDatabase(String name, Database db) {
        super(name);
        this.db = db;
    }



    public void showDatabase() throws Exception {
        ArrayList<Superhero> superheroes = db.getSuperheroList();
        Table table = new Table("Superheros",
                new ArrayList<>(List.of("Superhero Name","Real Name",
                        "Human?","Superpower","Strength","Year Created")),true);
        for (Superhero hero : superheroes) {
            table.addRow(new Row().addCell(hero.getName())
                    .addCell(hero.getRealName())
                    .addCell(hero.isHuman())
                    .addCell(hero.getSuperPower())
                    .addCell(hero.getStrength())
                    .addCell(hero.getCreationYear()));
        }
        System.out.println(table.getTableString());
    }

    @Override
    public boolean show() throws Exception {
        showDatabase();
        return super.show();
    }
}
