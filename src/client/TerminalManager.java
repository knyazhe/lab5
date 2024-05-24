package client;

import server.commands.Exit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalManager {
    private static final Scanner sc = new Scanner(System.in);
    private static final Exit exit = new Exit("Выход", "exit");

    public String stdinline(){
        String line = sc.nextLine().toLowerCase().trim();
        if (line.equals("exit")){
            exit.apply();
            System.exit(0);
        }
        return line;
    }
    public ArrayList<String> stdinlist(){
        String tmp = sc.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
        ArrayList<String> line = new ArrayList<String>(List.of(tmp.split(" ")));
        return line;
    }
    public int stdinint() {
        String line = sc.nextLine().toLowerCase().trim();
        if (new Scanner(line).next().equals("exit")) {
            exit.apply();
            System.exit(0);
        }
        int tmp2 = 0;
        try {
            tmp2 = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Error! No such number");
        }

        return tmp2;
    }
    public void printTable(Object elementLeft, Object elementRight) {
        System.out.printf(" %-35s%-1s%n", elementLeft, elementRight);
    }
}
