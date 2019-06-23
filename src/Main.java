import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {



    public static void main(String... args){
        Simulation s = new Simulation();

        long totalBudgetI1 = 0;
        long totalBudgetU2 = 0;

        ArrayList<Item> phase1Items = s.loadItems("rsc/phase-1.txt");
        ArrayList<Item> phase2Items = s.loadItems("rsc/phase-2.txt");

        ArrayList<U1> rocketsU1 = s.loadU1(phase1Items);
        for (U1 u : rocketsU1){
            totalBudgetI1 += u.getCost();
        }
        System.out.println("Prawdopodobny budzet potrzebny na rakiety U1: "+totalBudgetI1+"mln");

        ArrayList<U2> rocketsU2 = s.loadU2(phase2Items);
        for (U2 u : rocketsU2){
            totalBudgetU2 += u.getCost();
        }
        System.out.println("Prawdopodobny budzet potrzebny na rakiety U1: "+totalBudgetU2 +"mln");


    }
}
