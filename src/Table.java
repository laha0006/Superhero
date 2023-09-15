import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Table {
    private final String LINE = "─";
    private final String SEPERATOR = "|";
    private final String CROSS = "┼";

    private final String TOP_T = "┬";
    private final String TOP_LEFT_CORNER = "┌";
    private final String TOP_RIGHT_CORNER = "┐";

    private final String BOT_T = "┴";
    private final String BOT_LEFT_CORNER = "└";
    private final String BOT_RIGHT_CORNER = "┘";

    private final String LEFT_EDGE_VERTICAL_SEPERATOR = "├";
    private final String RIGHT_EDGE_VERTICAL_SEPERATOR = "┤";

    private String header;
    private String rowTemplate;
    private String rowSeperator;
    private String rowTop;
    private String rowBottom;
    private ArrayList<Row> rows;
    private ArrayList<String> columns;
    private ArrayList<Integer> columnSizes;

    private int size;
    private int length;

    private StringBuilder sb;

    public Table(String header, ArrayList<String> columns) {
        this.header = header;
        this.columns = columns;

        size = columns.size();

        sb = new StringBuilder();
        rows = new ArrayList<>();
        columnSizes = new ArrayList<>();
        setInitColumnSizes();
    }
    private void setInitColumnSizes(){
        for(String s : columns) {
            columnSizes.add(s.length());
        }
    }
    private void calcColumnSizes() {
        for (Row row : rows) {
            int count = 0;
            ArrayList<Cell> cells = row.getCells();
            for (Cell cell : cells) {
                columnSizes.set(count,Math.max(columnSizes.get(0),cell.getSize()));
                count++;
            }
        }
        System.out.println(columnSizes);
    }

    public void addRow(Row row) throws Exception {
        if(row.getSize() == size) {
            rows.add(row);
        } else {
            throw new Exception("Row too short or long!");
        }
    }

    public void print() {
        calcColumnSizes();
        sb.append(header);
        System.out.printf(sb.toString());
    }

}
