package org.example;
import java.util.ArrayList;

public class CheeseList {

    private ArrayList<Cheese> cheeses = new ArrayList<>();

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }


}
