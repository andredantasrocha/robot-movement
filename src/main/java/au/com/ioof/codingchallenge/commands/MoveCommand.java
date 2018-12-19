package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.TableTop;

public class MoveCommand implements Command {
    public static final int STEP = 1;

    @Override
    public TableTop apply(TableTop tableTop) {
        TableTop candidate = tableTop;
        switch (tableTop.direction) {
            case EAST:
                candidate = new TableTop(tableTop.x + STEP, tableTop.y, tableTop.direction);
                break;
            case WEST:
                candidate = new TableTop(tableTop.x - STEP, tableTop.y, tableTop.direction);
                break;
            case NORTH:
                candidate = new TableTop(tableTop.x, tableTop.y + STEP, tableTop.direction);
                break;
            case SOUTH:
                candidate = new TableTop(tableTop.x, tableTop.y - STEP, tableTop.direction);
                break;
        }
        return candidate.isValid() ? candidate : tableTop;
    }
}
