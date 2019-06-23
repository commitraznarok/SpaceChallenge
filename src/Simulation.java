import jdk.nashorn.internal.ir.LiteralNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private long budget;

    public ArrayList<Item> loadItems(String filename)  {

        File f = new File(filename);
        ArrayList<Item> itemList = new ArrayList<>();

        try{
            Scanner s = new Scanner(f);
            long weight;

            while (s.hasNextLine()) {
                String line = s.nextLine();

                String name = line.substring(line.lastIndexOf("=") - 1);
                weight = Integer.parseInt(line.substring(line.lastIndexOf("=") + 1));

                //System.out.println("Do listy dodano przedmiot: "+name +" o masie: "+String.valueOf(weight));
                Item item = new Item(name, weight);
                itemList.add(item);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku z ładunkiem");
        }


        return itemList;
    }

    public ArrayList <U1> loadU1 (ArrayList<Item> loadedItems) {

        ArrayList<U1> u1List = new ArrayList<>();

        U1 rocket = new U1(100, 10000);

        for (Item item: loadedItems){
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }
            else{
                u1List.add(rocket);
                rocket = new U1(100, 10000);
                if (rocket.canCarry(item)){
                    rocket.carry(item);
                }
            }
        }

        return u1List;


    }

    public ArrayList <U2> loadU2 (ArrayList<Item> loadedItems) {

        ArrayList<U2> u2List = new ArrayList<>();

        U2 rocket = new U2(120, 18000);

        for (Item item: loadedItems){
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }
            else{
                u2List.add(rocket);
                rocket = new U2(120, 18000);
                if (rocket.canCarry(item)){
                    rocket.carry(item);
                }
            }
        }

        return u2List;
    }

    public long runSimulation(ArrayList<Rocket> rockets) {

        for ( Rocket r: rockets){
            r.launch();
            r.land();
        }

        return getBudget();
    }

    private long getBudget() {
        return budget;
    }

}
