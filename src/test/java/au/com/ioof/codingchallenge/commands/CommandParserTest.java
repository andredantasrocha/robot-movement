package au.com.ioof.codingchallenge.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void noPlaceCommandSpecified() {
        String[] instructions = new String[]{
                "MOVE",
                "REPORT"
        };

        Command[] commands = new CommandParser().parse(instructions);

        assertEquals(0, commands.length);
    }

    @Test
    void placeCommandInTheMiddle() {
        String[] instructions = new String[]{
                "MOVE",
                "PLACE 0,0,NORTH",
                "REPORT"
        };

        Command[] commands = new CommandParser().parse(instructions);

        assertEquals(2, commands.length);
        assertTrue(commands[0] instanceof PlaceCommand);
        assertTrue(commands[1] instanceof ReportCommand);
    }

    @Test
    void invalidPlaceCommand() {
        String[] instructions = new String[]{
                "MOVE",
                "PLACE 0,0,NOR",
                "REPORT"
        };

        Command[] commands = new CommandParser().parse(instructions);

        assertEquals(0, commands.length);
    }

    @Test
    void invalidCommandInTheMiddle() {
        String[] instructions = new String[]{
                "MOVE",
                "PLACE 0,0,NORTH",
                "JUMP",
                "REPORT"
        };

        Command[] commands = new CommandParser().parse(instructions);

        assertEquals(2, commands.length);
        assertTrue(commands[0] instanceof PlaceCommand);
        assertTrue(commands[1] instanceof ReportCommand);
    }

    @Test
    void allCommands() {
        String[] instructions = new String[]{
                "PLACE 0,0,NORTH",
                "MOVE",
                "LEFT",
                "RIGHT",
                "REPORT"
        };

        Command[] commands = new CommandParser().parse(instructions);

        assertEquals(5, commands.length);
        assertTrue(commands[0] instanceof PlaceCommand);
        assertTrue(commands[1] instanceof MoveCommand);
        assertTrue(commands[2] instanceof RotateCommand);
        assertTrue(commands[3] instanceof RotateCommand);
        assertTrue(commands[4] instanceof ReportCommand);
    }
}