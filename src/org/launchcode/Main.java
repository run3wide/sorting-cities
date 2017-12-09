package org.launchcode;

import org.launchcode.comparators.CompoundComparator;
import org.launchcode.comparators.NameComparator;
import org.launchcode.comparators.PopulationComparator;
import org.launchcode.comparators.StateComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();

        // TODO - Use different comparators here
        NameComparator nameComparator = new NameComparator();
        PopulationComparator populationComparator = new PopulationComparator();
        StateComparator stateComparator = new StateComparator();

        CompoundComparator compoundComparator = new CompoundComparator();

        compoundComparator.addComparator(stateComparator);
        compoundComparator.addComparator(nameComparator);



        cities.sort(compoundComparator);

        printCities(cities);

    }

    private static void printCities(ArrayList<City> cities) {

        System.out.println(City.getTableHeader());

        for(City c : cities) {
            System.out.println(c);
        }

    }
}
