import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();

        String header = "HeaderHere";
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Superheroheroherr");
        columns.add("Name");
        columns.add("Human");
        columns.add("Superpower");
        columns.add("Strength");
        columns.add("Year Created");
        Table table = new Table(header, columns,true);
        table.addRow(new Row()
                .addCell("Superman")
                .addCell("Clark Kent")
                .addCell(false)
                .addCell("Super strength.")
                .addCell(9000)
                .addCell(1954));

        Table table2 = new Table("TFT Tier List", new ArrayList<>(List.of("Tier",
                "Synergy", "Difficulity")),false);
        table2.addRow(new Row()
                .addCell("S")
                .addCell("Blightwaterr")
                .addCell(0));

        table2.addRow(new Row()
                .addCell("A")
                .addCell("Azir")
                .addCell(3));;
        ArrayList<String> columns3 = new ArrayList<>();
        columns3.add("ColumnOne");
        columns3.add("ColumnTwo");
        Table table3 = new Table("Header",columns3,false);
        table3.addRow(new Row().addCell("Test").addCell("Test2"));
        System.out.print(table3.getTableString());
        System.out.print(table2.getTableString());


    }
}