package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.Direction;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private static final String PLACE_COMMAND = "PLACE\\s\\d,\\d,(NORTH|SOUTH|EAST|WEST)";
    private static final String VALID_COMMAND = "(MOVE|LEFT|RIGHT|REPORT)";

    public Command[] parse(String[] instructions) {
        List<String> validCommands = new ArrayList<>();
        boolean placeCommandSpecified = false;
        for (String instruction : instructions) {
            if (isPlaceCommand(instruction)) {
                placeCommandSpecified = true;
            }
            if (placeCommandSpecified && isValidCommand(instruction)) {
                validCommands.add(instruction);
            }
        }
        return commandify(validCommands);
    }

    private boolean isPlaceCommand(String instruction) {
        return instruction.matches(PLACE_COMMAND);
    }

    private boolean isValidCommand(String instruction) {
        return isPlaceCommand(instruction) || instruction.matches(VALID_COMMAND);
    }

    private Command[] commandify(List<String> instructions) {
        List<Command> result = new ArrayList<>();
        for (String instruction : instructions) {
            if (instruction.startsWith("PLACE")) {
                String[] tokens = instruction.split("(\\s|,)");
                int x = Integer.valueOf(tokens[1]);
                int y = Integer.valueOf(tokens[2]);
                Direction direction = Direction.valueOf(tokens[3]);
                result.add(new PlaceCommand(x, y, direction));
            } else if (instruction.equals("MOVE")) {
                result.add(new MoveCommand());
            } else if (instruction.equals("LEFT")) {
                result.add(new RotateCommand("LEFT"));
            } else if (instruction.equals("RIGHT")) {
                result.add(new RotateCommand("RIGHT"));
            } else if (instruction.equals("REPORT")) {
                result.add(new ReportCommand());
            }
        }

        return result.stream().toArray(Command[]::new);
    }
}
