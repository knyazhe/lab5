package server;

import client.TerminalManager;
import server.model.Coordinates;
import server.model.Dragon;
import server.model.DragonHead;
import server.model.enums.Color;
import server.model.enums.DragonCharacter;

import java.util.Arrays;

public class DragonCreator {
    private static TerminalManager console = new TerminalManager();

    public static Dragon createDragon() {
        String name = getNameFromUser();
        int age = getAgeFromUser();
        Coordinates coordinates = getCoordinatesFromUser();
        Boolean speaking = getSpeakingFromUser();
        Color color = getColorFromUser();
        DragonCharacter character = getCharacterFromUser();
        DragonHead head = new DragonHead(getToothCountFromUser());

        return new Dragon(age, character, color, coordinates, null, head, null, name, speaking);
    }

    private static String getNameFromUser() {
        System.out.print("Enter the name: ");
        return console.stdinline();
    }

    private static int getAgeFromUser() {
        try {
            while (true) {
                System.out.print("Enter the age: ");
                String line = console.stdinline();
                int age = Integer.parseInt(line);
                if (age > 0) {
                    return age;
                } else {
                    System.out.println("Invalid age");
                }
            }
        } catch (Throwable e) {
            System.out.println("Invalid input");
        }
        return -1;
    }

    private static Coordinates getCoordinatesFromUser() {
        try {
            Double x, y;
            while (true) {
                System.out.print("Enter x: ");
                String line = console.stdinline();
                if (line.isEmpty()) {
                    //
                }
                if (!line.isEmpty()) {
                    x = Double.parseDouble(line);
                    break;
                }
            }
            while (true) {
                System.out.print("Enter y: ");
                String line = console.stdinline();
                if (line.isEmpty()) {
                    //
                }
                if (!line.isEmpty()) {
                    y = Double.parseDouble(line);
                    break;
                }
            }
            Coordinates coordinates = new Coordinates(x, y);
            return coordinates;
        } catch (Throwable e) {
            System.out.println("Invalid input");
        }
        return null;
    }

    private static boolean getSpeakingFromUser() {
        boolean speaking = false;
        try {
            while (true) {
                System.out.print("Enter the speaking: ");
                String line = console.stdinline();
                if (line.isEmpty() || line.equals("false")) {
                    break;
                }
                if (line.equals("true")) {
                    speaking = true;
                    break;
                } else {
                    System.out.println("Invalid speaking");
                }
            }
        } catch (Throwable e) {
            System.out.println("Invalid input");
        }
        return speaking;
    }

    private static DragonCharacter getCharacterFromUser() {
        DragonCharacter character = null;
        while (true) {
            System.out.print("Choose the character of dragon " + Arrays.toString(DragonCharacter.values()) + ": ");
            String line = console.stdinline();
            if (!line.isEmpty()){
                try {
                    character = DragonCharacter.valueOf(line.toUpperCase());
                    return character;
                } catch (Throwable e) {
                    System.out.println("Invalid character");
                }
            }
        }
    }

    private static Color getColorFromUser() {
        Color color = null;
        while (true) {
            System.out.print("Choose the color of dragon " + Arrays.toString(Color.values()) + ": ");
            String line = console.stdinline();
            try {
                color = Color.valueOf(line.toUpperCase());
                return color;
            } catch (Throwable e) {
                System.out.println("Invalid color");
            }
        }
    }


    private static Long getToothCountFromUser() {
        Long toothCount = null;
        try {
            while (true) {
                System.out.print("Enter the tooth count: ");
                String line = console.stdinline();
                toothCount = Long.parseLong(line);
                if (toothCount >= 0) {
                    return toothCount;
                } else {
                    System.out.println("Invalid tooth count");
                }
            }
        } catch (Throwable e) {
            System.out.println("Invalid input");
        }
        return -1L;
    }
}
