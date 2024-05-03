import model.Dragon;
import model.Filler;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Dragon> dragons = new ArrayList<Dragon>();

    public static void main(String[] args) {
        Object WeaponType;
        Filler filler = new Filler();
        Dragon gensek = new Dragon();
        Dragon noname = new Dragon();

        filler.Fill(gensek);
        filler.Fill(noname);
        dragons.add(gensek);
        dragons.add(noname);

        for (var e : dragons) System.out.println(e);
    }
}