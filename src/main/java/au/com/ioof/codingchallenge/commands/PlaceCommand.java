package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;

public class PlaceCommand implements Command {
    private final int x;
    private final int y;
    private final Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public TableTop apply(TableTop tableTop) {
        TableTop candidate = new TableTop(x, y, direction);
        return candidate.isValid() ? candidate : tableTop;
    }
}
