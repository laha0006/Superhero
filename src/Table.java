import java.util.ArrayList;

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
    private ArrayList<String> rows;

    private int size;

    private StringBuilder sb;


    public Table() {
        sb = new StringBuilder();
    }

    public Table(String header, String rowTemplate) {
        this.header = header;
        this.rowTemplate = rowTemplate;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void print() {
        sb.append(header);
        System.out.printf(sb.toString());
    }

}
