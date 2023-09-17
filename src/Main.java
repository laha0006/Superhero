import table.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();

        ArrayList<String> columns = new ArrayList<>(List.of("Superhero","Name","Human","Superpower","Strenght","Year Created"));
        Table table1 = new Table("Superhero CRUD Project", columns, true);
        table1.addRow(new Row().addCell("Superman").addCell("Clark Kent").addCell(false).addCell("Super strength.").addCell(9000).addCell(1954));

        Table table2 = new Table("TFT Tier List", new ArrayList<>(List.of("Tier", "Synergy", "Difficulity")), true);
        table2.addRow(new Row().addCell("S").addCell("Blightwaterr").addCell(0));
        table2.addRow(new Row().addCell("A").addCell("Azir").addCell(3));

        ArrayList<String> columns3 = new ArrayList<>(List.of("Column ONe","Column Two"));
        Table table3 = new Table("Header", columns3, true);
        table3.addRow(new Row().addCell("Test100").addCell("Test100"));
        table3.addRow(new Row().addCell("Test200").addCell("Test200"));
        table3.addRow(new Row().addCell("Test300").addCell("Test300"));

        System.out.println(table3.getTableString());
        table3.addRow(new Row().addCell("Test4000000000000000000000000").addCell("Test40000000000000000000000000"));
        table3.addRow(new Row().addCell("Test5000000000000000000000000").addCell("Test50000000000000000000000000"));
        table3.addRow(new Row().addCell("Test6000000000000000000000000").addCell("Test60000000000000000000000000"));
        System.out.println(table3.getTableString());
        System.out.println(table2.getTableString());
        System.out.println(table1.getTableString());
        System.out.print("Superhero>>");

    }
}