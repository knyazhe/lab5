package client;

import server.commands.Exit;
import server.model.Dragon;
import server.model.MyCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// by this class program asks user for some information

public class TerminalManager {
    private static final Scanner sc = new Scanner(System.in);
    private static final Exit exit = new Exit("exit", "exit", 0);


    private void enterString(){
        System.out.print("> ");
    }
    public void skip(){
        if (!sc.hasNext()){
            sc.next();
        }
    }
    public String stdinline(){
        this.enterString();
        String line = sc.nextLine().toLowerCase().trim();
        if (line.equals("exit")){
            exit.apply();
        }
        return line;
    }
    public ArrayList<String> stdinlist(){
        this.enterString();
        return new ArrayList<String>(List.of(sc.nextLine().toLowerCase().trim().split(" ")));
    }

    public void printTable(Object elementLeft, Object elementRight) {
        System.out.printf(" %-35s%-1s%n", elementLeft, elementRight);
    }
    public void printText(Object text) {
        System.out.println(text.toString());
    }

    public void printCollection(MyCollection collection){
        if (collection.isEmpty()) {
            this.printText("[i] Collection is empty.");
        } else {
            for (Dragon dragon : collection) {
                this.printText(dragon);
            }
        }
    }
}
