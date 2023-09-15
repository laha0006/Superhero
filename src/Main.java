import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserInterface userInterface = new UserInterface();
//        userInterface.start();
        String header = "HeaderHere";
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Superhero");
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



    }
}