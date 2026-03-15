package org.example;
import java.io.FileReader;
import java.io.BufferedReader;

public class CheeseReader {
    
    private String fileName;
    private CheeseParser parser = new CheeseParser();
    private CheeseRowCleaner cleaner = new CheeseRowCleaner();

    public CheeseReader(String fileName) {
        this.fileName = fileName;
    }

    public CheeseList readCheeses() {
        CheeseList cheeseList = new CheeseList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine(); //Skipping top tow of labels in the CSV
            String line;
            while ((line = reader.readLine()) != null) {
                Cheese cheese = deserializeCheese(line);
                cheeseList.addCheese(cheese);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cheeseList;
    }

    private Cheese deserializeCheese(String line) {
        String cleanedLine = cleaner.clean(line);
        Cheese cheese = parser.parse(cleanedLine);
        return cheese;
    }
}
