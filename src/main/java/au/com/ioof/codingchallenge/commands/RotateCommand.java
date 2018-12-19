package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.TableTop;

public class RotateCommand implements Command {
    private final String rotation;

    public RotateCommand(String rotation) {
        this.rotation = rotation;
    }

    @Override
    public TableTop apply(TableTop tableTop) {
        return null;
    }
}
