import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<U1> u1s = new ArrayList<>();
        ArrayList<U2> u2s = new ArrayList<>();

        Simulation s = new Simulation();

        items = s.loadItems("./phase-1.txt");
        u1s = s.loadU1(items);
        System.out.println("Symulacja fazy 1 z użyciem rakiet U1");
        s.runSimulation(u1s);

        items = s.loadItems("./phase-1.txt");
        u2s = s.loadU2(items);
        System.out.println("Symulacja fazy 1 z użyciem rakiet U2");
        s.runSimulation(u2s);

        items = s.loadItems("./phase-2.txt");
        u1s = s.loadU1(items);
        System.out.println("Symulacja fazy 2 z użyciem rakiet U1");
        s.runSimulation(u1s);

        items = s.loadItems("./phase-2.txt");
        u2s = s.loadU2(items);
        System.out.println("Symulacja fazy 2 z użyciem rakiet U2");
        s.runSimulation(u2s);
    }
}
