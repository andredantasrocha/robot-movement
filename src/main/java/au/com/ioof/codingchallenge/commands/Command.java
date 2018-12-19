package au.com.ioof.codingchallenge.commands;

import au.com.ioof.codingchallenge.TableTop;

public interface Command {
    TableTop apply(TableTop tableTop);
}
