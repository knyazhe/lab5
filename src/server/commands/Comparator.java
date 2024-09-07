package server.commands;

import server.model.Dragon;

public class Comparator {
    public static int comp(Dragon d1, Dragon d2) {
        if(d1.getAge()>d2.getAge()) {
            return 1;
        } else if (d1.getAge()<d2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
