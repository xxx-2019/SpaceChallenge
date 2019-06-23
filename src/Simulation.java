import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulation {

    public ArrayList loadItems(String filename) {
        ArrayList<Item> out = new ArrayList();
        Scanner sc;
        String line;
        int es;
        File f = new File(filename);

        try {
            sc = new Scanner(f);
            while (sc.hasNext()) {
                line = sc.nextLine();
                es = line.indexOf("=");
                Item item = new Item();
                item.setName(line.substring(0,es));
                item.setWeight(Integer.parseInt(line.substring(es + 1)));
                out.add(item);
            }
        } catch (Exception e) {
            System.out.println("Brak pliku: " + filename);
        }
        Collections.sort(out);
        //Collections.reverse(out);
        return out;
    }
    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> u1s = new ArrayList<>();
        U1 u1 ;

        do {
            u1 = new U1(100000000,0, 8000, 0.05, 0.01);
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u1.canCerry(items.get(i))) {
                    u1.carry(items.get(i));
                    items.remove(i);
                }
            }
            u1s.add(u1);
        } while (items.size() > 0);

        return u1s;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> u2s = new ArrayList<>();
        U2 u2 ;

        do {
            u2 = new U2(120000000,0, 11000, 0.04, 0.08);
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u2.canCerry(items.get(i))) {
                    u2.carry(items.get(i));
                    items.remove(i);
                }
            }
            u2s.add(u2);
        } while (items.size() > 0);

        return u2s;
    }

    public void runSimulation(ArrayList items) {
        long allCost = 0;
        boolean result;
        int numberOfCrash = 0;
        int numberOfExplode = 0;

        Rocket r;

        for (int i = 0; i < items.size(); i++) {
            r = (Rocket)items.get(i);
            do {
                allCost += r.getCost();
                if (r.launch()) {
                    if (r.land()) {
                        result = true;
                    } else {
                        numberOfCrash++;
                        result = false;
                    }
                } else {
                    numberOfExplode++;
                    result = false;
                }
            } while(!result);
        }
        // Wynik symulacji:
        System.out.println("Wynik symulacji:");
        System.out.println("Liczba użytych rakiet: " + (items.size() + numberOfExplode + numberOfCrash));
        System.out.println("Liczba rakiet, które eksplodowały przy starcie: " + numberOfExplode);
        System.out.println("Liczba rakiet, które uległy rozbiciu podczas londowania: " + numberOfCrash);
        System.out.println("Całkowity koszt kampani: " + allCost);
        System.out.println("");
    }
}
