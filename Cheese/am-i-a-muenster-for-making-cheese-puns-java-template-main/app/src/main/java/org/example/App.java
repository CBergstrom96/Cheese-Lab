package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Personal reminder that we only need:
//Number of cheeses that use pasteurized milk
//Number of cheeses that use raw milk (both found in MilkTreatmentTypeEn column)
//Number of ORGANIC cheeses that have moisture percent greater than 41.0% (MoisturePercent column)
//Number of cheeses for each animal type (MilkTypeEn column) 

public class App {

    public static void main(String[] args) throws IOException { 
        CheeseReader reader = new CheeseReader("cheese_data.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        CheeseList cheeseList = reader.readCheeses();

        int pasteurizedCount = 0;
        int rawMilkCount = 0;
        int organic41Plus = 0;
        int cowCount = 0;
        int goatCount = 0;
        int eweCount = 0;
        int buffaloCount = 0;
        String highestAnimal = "";
        int higheseAnimalCount = 0;

        for(Cheese cheese : cheeseList.getCheeses()) {
            if(cheese.getMilkType().equalsIgnoreCase("pasteurized")) {
                pasteurizedCount++;
            }
            if(cheese.getMilkType().equalsIgnoreCase("raw milk")) {
                rawMilkCount++;
            }
            if(cheese.isOrganic() && cheese.getMoisturePercent() > 41.0) {
                organic41Plus++;
            }
            if(cheese.getSourceAnimal().equalsIgnoreCase("cow")) {
                cowCount++;
            }
            if(cheese.getSourceAnimal().equalsIgnoreCase("goat")) {
                goatCount++;
            }
            if(cheese.getSourceAnimal().equalsIgnoreCase("ewe")) {
                eweCount++;
            }
            if(cheese.getSourceAnimal().equalsIgnoreCase("buffalo cow")) {
                buffaloCount++;
            }
        }

        if(cowCount > higheseAnimalCount) {
            higheseAnimalCount = cowCount;
            highestAnimal = "Cow";
        }
        if(goatCount > higheseAnimalCount) {
            higheseAnimalCount = goatCount;
            highestAnimal = "Goat";
        }
        if(eweCount > higheseAnimalCount) {
            higheseAnimalCount = eweCount;
            highestAnimal = "Ewe";
        }
        if(buffaloCount > higheseAnimalCount) {
            higheseAnimalCount = buffaloCount;
            highestAnimal = "Buffalo Cow";
        }

        writer.write("Number of cheeses using pasteurized milk: " + pasteurizedCount);
        writer.newLine();

        writer.write("Number of cheeses using raw milk: " + rawMilkCount);
        writer.newLine();

        writer.write("Number of organic cheeses with moisture > 41%: " + organic41Plus);
        writer.newLine();

        writer.newLine();

        writer.write("Cow cheeses: " + cowCount);
        writer.newLine();

        writer.write("Goat cheeses: " + goatCount);
        writer.newLine();

        writer.write("Ewe cheeses: " + eweCount);
        writer.newLine();

        writer.write("Buffalo Cow cheeses: " + buffaloCount);
        writer.newLine();

        writer.write("Animal with the most cheeses: " + highestAnimal);
        writer.newLine();

        writer.write("It was used in the production of " + higheseAnimalCount + " cheeses.");
        writer.newLine();

        writer.close();
    }
}
