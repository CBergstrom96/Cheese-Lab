package org.example;

//Personal reminder that we only need:
//Number of cheeses that use pasteurized milk
//Number of cheeses that use raw milk (both found in MilkTreatmentTypeEn column)
//Number of ORGANIC cheeses that have moisture percent greater than 41.0% (MoisturePercent column)
//Number of cheeses for each animal type (MilkTypeEn column) 

public class Cheese {

    private int cheeseID; //Just realized I never used this
    private String milkType; //Pasteurized or raw
    private int organic; //0 is not organic, 1 is organic
    private double moisturePercent;
    private String sourceAnimal; //What animal milk came from

    public Cheese(int cheeseID, String milkType, int organic, double moisturePercent, String sourceAnimal) {
        this.cheeseID = cheeseID;
        this.milkType = milkType;
        this.organic = organic;
        this.moisturePercent = moisturePercent;
        this.sourceAnimal = sourceAnimal;
    }

    public int getCheeseID() {
        return cheeseID;
    }

    public String getMilkType() {
        return milkType;
    }

    public Boolean isOrganic() {
        if(organic == 1) {
            return true;
        } else {
            return false;
        }
    }

    public double getMoisturePercent() {
        return moisturePercent;
    }

    public String getSourceAnimal() {
        return sourceAnimal;
    }
}
