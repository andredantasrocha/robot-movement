package au.com.ioof.codingchallenge;

public class RobotMovement {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("A file with commands must be provided");
        }
        new RobotMovement().run(args[0]);
    }

    public void run(String commandsFile) {

    }

    private TableTop move(Position position, Direction direction) {
        return null;
    }

    private TableTop rotate(Rotation rotation) {
        return null;
    }
}
