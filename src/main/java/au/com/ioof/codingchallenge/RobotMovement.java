package au.com.ioof.codingchallenge;

import au.com.ioof.codingchallenge.commands.Command;

public class RobotMovement {
    private final TableTop tableTop;

    public RobotMovement(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("A file with commands must be provided");
        }
        new RobotMovement(new TableTop(5, 5)).run(null);
    }

    public void run(Command[] commands) {

    }
}
