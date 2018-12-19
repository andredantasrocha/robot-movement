package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.TableTop;

public class ReportCommand implements Command {
    private String output;

    @Override
    public TableTop apply(TableTop tableTop) {
        output = String.format("Output: %d,%d,%s", tableTop.x, tableTop.y, tableTop.direction);
        System.out.printf(output);
        return tableTop;
    }

    public String getOutput() {
        return output;
    }
}
