import java.util.ArrayList;

public class Table {
    private final String LINE = "─";
    private final String SEPERATOR = "│";
    private final String CROSS = "┼";

    private final String TOP_T = "┬";
    private final String TOP_LEFT_CORNER = "┌";
    private final String TOP_RIGHT_CORNER = "┐";

    private final String BOT_T = "┴";
    private final String BOT_LEFT_CORNER = "└";
    private final String BOT_RIGHT_CORNER = "┘";

    private final String LEFT_EDGE_SEPARATOR = "├";
    private final String RIGHT_EDGE_SEPARATOR = "┤";

    private final String WHITESPACE = " ";

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

    private void calcLength() {
        int sum = 0;
        if (!columnSizes.isEmpty()) {
            for (int i : columnSizes) {
                sum += i;
            }
        }
        length = sum + size * 4 - 1;
    }

    private void setInitColumnSizes() {
        for (String s : columns) {
            columnSizes.add(s.length());
        }
    }

    private void calcColumnSizes() {
        for (Row row : rows) {
            int count = 0;
            ArrayList<Cell> cells = row.getCells();
            for (Cell cell : cells) {
                columnSizes.set(count, Math.max(columnSizes.get(0), cell.getSize()));
                count++;
            }
        }
        System.out.println(columnSizes);
    }

    public void addRow(Row row) throws Exception {
        if (row.getSize() == size) {
            rows.add(row);
        } else {
            throw new Exception("Row too short or long!");
        }
    }

    private String createBotHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(LEFT_EDGE_SEPARATOR);
        for (int i : columnSizes) {
            sb.append(LINE.repeat(i + 2));
            sb.append(TOP_T);
        }
        sb.append(RIGHT_EDGE_SEPARATOR);
        return sb.toString();
    }

    private void createHeader() {
        String tempHeader = "";
        int length = header.length();
        int spaces = (this.length - (length)) / 2;
        System.out.println("spaces = " + spaces);
        System.out.println("length = " + this.length);
        System.out.println("locaLength = " + length);
        String headerTop = TOP_LEFT_CORNER + LINE.repeat(this.length - 2) + TOP_RIGHT_CORNER;
        //String headerBot = BOT_LEFT_CORNER + TOP_T.repeat(this.length-2) + BOT_RIGHT_CORNER;
        tempHeader += headerTop;
        tempHeader += "\n";
        tempHeader += SEPERATOR + WHITESPACE.repeat(spaces - 1);
        tempHeader += header;
        tempHeader += (length % 2 == 0) ? (WHITESPACE.repeat(spaces - 1) + SEPERATOR) : (WHITESPACE.repeat(spaces) + SEPERATOR);
        tempHeader += "\n";
        tempHeader += createBotHeader();
        header = tempHeader;
    }

    public String createColumns() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append(SEPERATOR).append(" ");
        for (String s : columns) {
            String template = "";
            template +="%-"+(columnSizes.get(count))+("s");
            if(count != size-1) {
                template +=" " + SEPERATOR + (" ");
            }
            count++;
            String tempString = String.format(template,s);
            sb.append(tempString);
        }
        sb.append(" ").append(SEPERATOR);
        return sb.toString();
    }

    public void print() {
        calcColumnSizes();
        calcLength();
        createHeader();
        //sb.append(header);
        //System.out.printf(sb.toString());
        String cols = createColumns();
        System.out.println(header);
        System.out.println(cols);
        System.out.println("cols.length() = " + cols.length());

    }

}
