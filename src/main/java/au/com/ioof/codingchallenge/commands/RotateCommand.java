package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;

public class RotateCommand implements Command {
    private final String rotation;

    public RotateCommand(String rotation) {
        this.rotation = rotation;
    }

    @Override
    public TableTop apply(TableTop tableTop) {
        if (rotation == "RIGHT") {
            return rotateRight(tableTop);
        } else if (rotation == "LEFT") {
            return rotateLeft(tableTop);
        } else {
            return tableTop;
        }
    }

    private TableTop rotateRight(TableTop tableTop) {
        switch (tableTop.direction) {
            case EAST:
                return new TableTop(tableTop.x, tableTop.y, Direction.SOUTH);
            case WEST:
                return new TableTop(tableTop.x, tableTop.y, Direction.NORTH);
            case NORTH:
                return new TableTop(tableTop.x, tableTop.y, Direction.EAST);
            case SOUTH:
                return new TableTop(tableTop.x, tableTop.y, Direction.WEST);
            default:
                return tableTop;
        }
    }

    private TableTop rotateLeft(TableTop tableTop) {
        switch (tableTop.direction) {
            case EAST:
                return new TableTop(tableTop.x, tableTop.y, Direction.NORTH);
            case WEST:
                return new TableTop(tableTop.x, tableTop.y, Direction.SOUTH);
            case NORTH:
                return new TableTop(tableTop.x, tableTop.y, Direction.WEST);
            case SOUTH:
                return new TableTop(tableTop.x, tableTop.y, Direction.EAST);
            default:
                return tableTop;
        }
    }
}
