package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateCommandTest {
    @Test
    void invalidRotation() {
        TableTop tableTop = new TableTop(0, 0, Direction.EAST);
        Command command = new RotateCommand("UP");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(tableTop, newTableTop);
    }

    @Test
    void rotateRightFromNorth() {
        TableTop tableTop = new TableTop(0, 0, Direction.NORTH);
        Command command = new RotateCommand("RIGHT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.EAST, newTableTop.direction);
    }

    @Test
    void rotateRightFromEast() {
        TableTop tableTop = new TableTop(0, 0, Direction.EAST);
        Command command = new RotateCommand("RIGHT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.SOUTH, newTableTop.direction);
    }

    @Test
    void rotateRightFromSouth() {
        TableTop tableTop = new TableTop(0, 0, Direction.SOUTH);
        Command command = new RotateCommand("RIGHT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.WEST, newTableTop.direction);
    }

    @Test
    void rotateRightFromWest() {
        TableTop tableTop = new TableTop(0, 0, Direction.WEST);
        Command command = new RotateCommand("RIGHT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.NORTH, newTableTop.direction);
    }

    @Test
    void rotateLeftFromNorth() {
        TableTop tableTop = new TableTop(0, 0, Direction.NORTH);
        Command command = new RotateCommand("LEFT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.WEST, newTableTop.direction);
    }

    @Test
    void rotateLeftFromWest() {
        TableTop tableTop = new TableTop(0, 0, Direction.WEST);
        Command command = new RotateCommand("LEFT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.SOUTH, newTableTop.direction);
    }

    @Test
    void rotateLeftFromSouth() {
        TableTop tableTop = new TableTop(0, 0, Direction.SOUTH);
        Command command = new RotateCommand("LEFT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.EAST, newTableTop.direction);
    }

    @Test
    void rotateLeftFromEast() {
        TableTop tableTop = new TableTop(0, 0, Direction.EAST);
        Command command = new RotateCommand("LEFT");

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(Direction.NORTH, newTableTop.direction);
    }
}