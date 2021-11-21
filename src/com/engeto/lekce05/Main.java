package com.engeto.lekce05;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	Countries countries = new Countries();
    countries.readListFromFile(Settings.FILE_NAME);
        Map<String, Double> countryAbove= new HashMap<>();
        countryAbove=countries.countryAbove();
        System.out.println(countryAbove);
    }
}
