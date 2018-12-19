package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {
    private Command command;

    @BeforeEach
    void setUp() {
        command = new MoveCommand();
    }

    @Test
    void validEastMove() {
        TableTop tableTop = new TableTop();
        for (int i = 0; i < 3; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(3, tableTop.x);
        assertEquals(0, tableTop.y);
        assertEquals(Direction.EAST, tableTop.direction);
    }

    @Test
    void invalidEastMove() {
        TableTop tableTop = new TableTop();
        for (int i = 0; i < 10; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(4, tableTop.x);
        assertEquals(0, tableTop.y);
        assertEquals(Direction.EAST, tableTop.direction);
    }

    @Test
    void validWestMove() {
        TableTop tableTop = new TableTop(4, 0, Direction.WEST);
        for (int i = 0; i < 3; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(1, tableTop.x);
        assertEquals(0, tableTop.y);
        assertEquals(Direction.WEST, tableTop.direction);
    }

    @Test
    void invalidWestMove() {
        TableTop tableTop = new TableTop(4, 0, Direction.WEST);
        for (int i = 0; i < 10; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(0, tableTop.x);
        assertEquals(0, tableTop.y);
        assertEquals(Direction.WEST, tableTop.direction);
    }

    @Test
    void validNorthMove() {
        TableTop tableTop = new TableTop(0, 0, Direction.NORTH);
        for (int i = 0; i < 3; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(0, tableTop.x);
        assertEquals(3, tableTop.y);
        assertEquals(Direction.NORTH, tableTop.direction);
    }

    @Test
    void invalidNorthMove() {
        TableTop tableTop = new TableTop(0, 0, Direction.NORTH);
        for (int i = 0; i < 10; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(0, tableTop.x);
        assertEquals(4, tableTop.y);
        assertEquals(Direction.NORTH, tableTop.direction);
    }

    @Test
    void validSouthMove() {
        TableTop tableTop = new TableTop(0, 4, Direction.SOUTH);
        for (int i = 0; i < 3; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(0, tableTop.x);
        assertEquals(1, tableTop.y);
        assertEquals(Direction.SOUTH, tableTop.direction);
    }

    @Test
    void invalidSouthMove() {
        TableTop tableTop = new TableTop(0, 4, Direction.SOUTH);
        for (int i = 0; i < 10; i++) {
            tableTop = command.apply(tableTop);
        }

        assertEquals(0, tableTop.x);
        assertEquals(0, tableTop.y);
        assertEquals(Direction.SOUTH, tableTop.direction);
    }
}