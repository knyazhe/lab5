import commands.Exit;

import java.util.Scanner;

public class ConsoleManager {
    private static Scanner sc = new Scanner(System.in);
    private static Exit exit = new Exit("Выход", "exit");
    public String stdinln(){
        String line = sc.nextLine().toLowerCase().trim();
        if (line.equals("exit")){
            exit.apply();
        }
        return line;
    }
}
