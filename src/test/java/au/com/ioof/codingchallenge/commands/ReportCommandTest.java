package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;
import au.com.ioof.codingchallenge.TableTop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportCommandTest {
    @Test
    void output() {
        TableTop tableTop = new TableTop(2, 4, Direction.WEST);
        ReportCommand command = new ReportCommand();

        TableTop newTableTop = command.apply(tableTop);

        assertEquals(tableTop, newTableTop);
        assertEquals("Output: 2,4,WEST", command.getOutput());
    }
}
