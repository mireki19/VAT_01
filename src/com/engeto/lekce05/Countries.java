package com.engeto.lekce05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Double.parseDouble;

public class Countries {

    private List<Country> countries = new ArrayList();

    public void addCountry(Country country){
        countries.add(country);
    }



    public void readListFromFile(String fileName){
        countries.clear();

        try (Scanner scanner = new Scanner(new File(fileName))){
            int lineNumber=0;

            while (scanner.hasNextLine()) {
                lineNumber++;
                String nextLine = scanner.nextLine();
                String[] items = nextLine.split(Settings.ELEMENT_SEPARATOR);
                try {
                    double fullTax;
                    double lowTax;
                    fullTax=parseDouble(items[2]);
                    lowTax=parseDouble(items[3]);
                    boolean parkingRate;
                    parkingRate=Boolean.parseBoolean(items[4]);
                    Country country = new Country(items[0], items[1], fullTax, lowTax,parkingRate);
                    countries.add(country);
                } catch (Exception ex) {
                    System.err.println("Chybný formát dat na řádku "+lineNumber+" v souboru "+fileName+"\n"+
                            "načteny jen bezchybné řádky souboru");
                }

            }
        }
        catch (FileNotFoundException ex) {

        }


    }

    public Map countryAbove(){
        Map<String, Double> countryAbove=new HashMap();
        for (Country country:countries){
            if (country.getFullRate()>Settings.VAT_CHECK)
                countryAbove.put(country.getCountryCode(), country.getFullRate());

        }
        return countryAbove;

    }


}
