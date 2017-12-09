package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {

    private static List<Comparator<City>> comparators = new ArrayList<>();

    @Override
    public int compare(City o1, City o2) {
        int index = 0;
        for (Comparator<City> comparator : comparators) {
            if (comparator.compare(o1, o2) == 0) {
                index++;
                continue;
            }
            break;
        }
        return comparators.get(index).compare(o1, o2);
    }

    public void addComparator(Comparator<City> comparator) {
        comparators.add(comparator);
    }
}
