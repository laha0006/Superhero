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
    private String columnsHeader;
    private String rowTemplate;
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
                sum += i+2;
            }
        }
        length = sum + size +1;
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
                columnSizes.set(count, Math.max(columnSizes.get(count),
                        Math.max(cell.getSize(),columns.get(count).length())));
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
        int count = 0;
        sb.append(LEFT_EDGE_SEPARATOR);
        for (int i : columnSizes) {
            sb.append(LINE.repeat(i + 2));
            if(count != size-1) sb.append(TOP_T);
            count++;
        }
        sb.append(RIGHT_EDGE_SEPARATOR);
        return sb.toString();
    }

    private void createHeader() {
        String tempHeader = "";
        StringBuilder sb = new StringBuilder();
        int length = header.length();
        int spaces = (this.length - (length)) / 2;
        int offset = 0;
        if(length % 2 == 0 || this.length % 2 == 0) {
            offset = length % 2 + this.length % 2;
        }
        sb.append(TOP_LEFT_CORNER)
                .append(LINE.repeat(this.length - 2))
                .append(TOP_RIGHT_CORNER).append("\n")
                .append(SEPERATOR)
                .append(WHITESPACE.repeat(spaces - 1))
                .append(header).append(WHITESPACE.repeat(spaces + offset - 1))
                .append(SEPERATOR)
                .append("\n")
                .append(createBotHeader());

        header = sb.toString();
    }

    public void createColumns() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append(SEPERATOR).append(" ");
        for (String s : columns) {
            String template = "";
            template += "%-" + (columnSizes.get(count)) + ("s");
            if (count != size - 1) {
                template += " " + SEPERATOR + (" ");
            }
            count++;
            String tempString = String.format(template, s);
            sb.append(tempString);
        }
        sb.append(" ").append(SEPERATOR);
        sb.append(createBottomColumRow());
        columnsHeader = sb.toString();
    }

    private String createBottomColumRow() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append("\n").append(LEFT_EDGE_SEPARATOR);
        for (int i : columnSizes) {
            sb.append(LINE.repeat(i+2));
            if(count != size-1) sb.append(CROSS);
            count++;
        }
        sb.append(RIGHT_EDGE_SEPARATOR);
        return sb.toString();
    }

    private void printRow() {

        for(Row row : rows) {
            int count = 0;
            ArrayList<Cell> cells = row.getCells();
            StringBuilder rowString = new StringBuilder();
            for (Cell cell : cells) {
                String type = "s";
                String prefix = "%";
                StringBuilder template = new StringBuilder();
                template.append(SEPERATOR).append(" ");
                if (cell.isINT()) {
                    type = "d";
                    prefix = "%";
                }
                ;
                if (cell.isDOUBLE()) {
                    type = ".0f";
                    prefix = "%";
                }
                if (cell.isSTRING()) {
                    type = "s";
                    prefix = "%-";
                }
                template.append(prefix).append(columnSizes.get(count)).append(type);
                if (count != size - 1) {
                    template.append(" ");
                } else {
                    template.append(" ").append(SEPERATOR);
                }
                if (cell.isINT()) {
                    rowString.append(String.format(template.toString(), cell.getIntValue()));
                } else if (cell.isDOUBLE()) {
                    rowString.append(String.format(template.toString(), cell.getDoubleValue()));
                } else if (cell.isSTRING()) {
                    rowString.append(String.format(template.toString(), cell.getStringValue()));
                } else {
                    String humanStatus = cell.getBool() ? "YES" : "NO";
                    rowString.append(String.format(template.toString(), humanStatus));
                }
                count++;
            }
            System.out.println(rowString.toString());
        }

    }
    public void print() {
        calcColumnSizes();
        calcLength();
        createHeader();
        createColumns();
        System.out.println(header);
        System.out.println(columnsHeader);
        printRow();



    }

}
