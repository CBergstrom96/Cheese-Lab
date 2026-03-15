package org.example;

public class CheeseRowCleaner {

    public String clean(String line) {
        String cleanedLine = "";
        Boolean inQuotes = false;
        for(int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if(currentChar == '"') {
                inQuotes = !inQuotes;
                continue;
            }
            if(inQuotes == true && currentChar == ',') {
                continue;
            }
            cleanedLine = cleanedLine + currentChar;
        }
        return cleanedLine;
    }
}
