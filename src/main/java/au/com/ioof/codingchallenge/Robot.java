package au.com.ioof.codingchallenge;

import au.com.ioof.codingchallenge.commands.Command;
import au.com.ioof.codingchallenge.commands.CommandParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Robot {
    private TableTop tableTop;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("A file with commands must be provided");
        }

        String[] instructions = read(args[0]);
        Command[] commands = new CommandParser().parse(instructions);
        new Robot(new TableTop()).run(commands);
    }

    private static String[] read(String commandsFile) {
        List<String> lines = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(commandsFile))) {
            while (s.hasNext()) {
                lines.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines.stream().toArray(String[]::new);
    }

    public Robot(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public void run(Command[] commands) {
        for(Command command: commands) {
            this.tableTop = command.apply(this.tableTop);
        }
    }
}
