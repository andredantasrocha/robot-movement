package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceCommandTest {

    @Test
    void validPlace() {
        TableTop tableTop = new TableTop();

        Command command = new PlaceCommand(2, 3, Direction.WEST);
        TableTop newTableTop = command.apply(tableTop);

        assertEquals(2, newTableTop.x);
        assertEquals(3, newTableTop.y);
        assertEquals(Direction.WEST, newTableTop.direction);
    }

    @Test
    void invalidX() {
        TableTop tableTop = new TableTop();

        Command command = new PlaceCommand(5, 2, Direction.WEST);
        assertEquals(tableTop, command.apply(tableTop));
    }

    @Test
    void invalidY() {
        TableTop tableTop = new TableTop();

        Command command = new PlaceCommand(2, 5, Direction.WEST);
        assertEquals(tableTop, command.apply(tableTop));
    }
}