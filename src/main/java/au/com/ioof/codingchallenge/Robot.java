package au.com.ioof.codingchallenge;

import au.com.ioof.codingchallenge.commands.Command;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Robot {
    private final TableTop tableTop;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("A file with commands must be provided");
        }
        new Robot(new TableTop(5, 5)).run(null);
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

    }
}
