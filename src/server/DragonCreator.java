package server;

import client.TerminalManager;
import server.model.Coordinates;
import server.model.Dragon;
import server.model.DragonHead;
import server.model.enums.Color;
import server.model.enums.DragonCharacter;
import java.time.LocalDateTime;

import java.util.Arrays;

// this class just creates Dragon class by asking user, validates user's data and returns Dragon class

public class DragonCreator {
    private static final TerminalManager terminalManager = new TerminalManager();


    public static Dragon createDragon() {
        String name = getNameFromUser();
        int age = getAgeFromUser();
        Coordinates coordinates = getCoordinatesFromUser();
        Boolean speaking = getSpeakingFromUser();
        Color color = getColorFromUser();
        DragonCharacter character = getCharacterFromUser();
        DragonHead head = new DragonHead(getToothCountFromUser());
//        id is will be created in collectionmanager
        java.time.LocalDateTime creationDate = LocalDateTime.now();
        return new Dragon(age, character, color, coordinates, creationDate, head, null, name, speaking);
    }

    private static String getNameFromUser() {
        terminalManager.printText("Enter the name: ");
        return terminalManager.stdinline();
    }

    private static int getAgeFromUser() {
        while (true) {
            try {
                terminalManager.printText("Enter the age: ");
                String line = terminalManager.stdinline();
                int age = Integer.parseInt(line);
                if (age > 0) {
                    return age;
                } else {
                    terminalManager.printText("[!] Invalid age");
                }
            } catch (Throwable e) {
                terminalManager.printText("[!] Invalid input");
            }
        }
    }

    private static Coordinates getCoordinatesFromUser() {
        try {
            Double x, y;
            while (true) {
                terminalManager.printText("Enter x coordinate: ");
                String line = terminalManager.stdinline();
                if (!line.isEmpty()) {
                    x = Double.parseDouble(line);
                    break;
                }
            }
            while (true) {
                terminalManager.printText("Enter y coordinate: ");
                String line = terminalManager.stdinline();
                if (!line.isEmpty()) {
                    y = Double.parseDouble(line);
                    break;
                }
            }
            return new Coordinates(x, y);
        } catch (Throwable e) {
            terminalManager.printText("[!] Invalid input");
        }
        return null;
    }

    private static boolean getSpeakingFromUser() {
        boolean speaking = false;
        try {
            while (true) {
                terminalManager.printText("Enter the speaking: ");
                String line = terminalManager.stdinline();
                if (line.isEmpty() || line.equals("false")) {
                    break;
                }
                if (line.equals("true")) {
                    speaking = true;
                    break;
                } else {
                    terminalManager.printText("[!] Invalid speaking");
                }
            }
        } catch (Throwable e) {
            terminalManager.printText("[!] Invalid input");
        }
        return speaking;
    }

    private static DragonCharacter getCharacterFromUser() {
        DragonCharacter character = null;
        while (true) {
            terminalManager.printText("Choose the character of dragon " + Arrays.toString(DragonCharacter.values()) + ": ");
            String line = terminalManager.stdinline();
            if (!line.isEmpty()){
                try {
                    character = DragonCharacter.valueOf(line.toUpperCase());
                    return character;
                } catch (Throwable e) {
                    terminalManager.printText("[!] Invalid character");
                }
            }
        }
    }

    private static Color getColorFromUser() {
        Color color = null;
        while (true) {
            terminalManager.printText("Choose the color of dragon " + Arrays.toString(Color.values()) + ": ");
            String line = terminalManager.stdinline();
            try {
                color = Color.valueOf(line.toUpperCase());
                return color;
            } catch (Throwable e) {
                terminalManager.printText("[!] Invalid color");
            }
        }
    }


    private static Long getToothCountFromUser() {
        Long toothCount = null;
        try {
            while (true) {
                terminalManager.printText("Enter the tooth count: ");
                String line = terminalManager.stdinline();
                toothCount = Long.parseLong(line);
                if (toothCount >= 0) {
                    return toothCount;
                } else {
                    terminalManager.printText("[!] Invalid tooth count");
                }
            }
        } catch (Throwable e) {
            terminalManager.printText("[!] Invalid input");
        }
        return -1L;
    }
}
