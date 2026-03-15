package org.example;

//A cheese object with a negative variable means it was not found in the CSV

public class CheeseParser {
    
    public Cheese parse(String line) {
        
        String[] desiredColumns = line.split(",");

        int cheeseID = -1;
        if(!desiredColumns[0].isEmpty()) {
            cheeseID = Integer.parseInt(desiredColumns[0]);
        }

        String milkType = desiredColumns[9];

        int organic = -1; //Number that is not 0 or 1 so it won't mess with my calculations
        if(!desiredColumns[6].isEmpty()) {
            organic = Integer.parseInt(desiredColumns[6]);
        }

        double moisturePercent = -1.0;
        if(!desiredColumns[3].isEmpty()) {
            moisturePercent = Double.parseDouble(desiredColumns[3]);
        }

        String sourceAnimal = desiredColumns[8];

        Cheese cheese = new Cheese(cheeseID, milkType, organic, moisturePercent, sourceAnimal);

        return cheese;
    }
}
