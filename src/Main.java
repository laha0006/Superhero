import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();




        String header = "HeaderHere";
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Superheroherohero");
        columns.add("Name");
        columns.add("Human");
        columns.add("Superpower");
        columns.add("Strength");
        columns.add("Year Created");
        Table table = new Table(header, columns);
        table.addRow(new Row()
                .addCell("Superman")
                .addCell("Clark Kent")
                .addCell(false)
                .addCell("Super strength.")
                .addCell(9000)
                .addCell(1954));

        table.print();
        System.out.println();
        Table table2 = new Table("TFT Tier List", new ArrayList<>(List.of("Tier",
                "Synergy", "Difficulity")));
        table2.addRow(new Row()
                .addCell("S")
                .addCell("Blightwater")
                .addCell("0"));

        table2.addRow(new Row()
                .addCell("A")
                .addCell("Azir")
                .addCell("3"));
        table2.print();
    }
}