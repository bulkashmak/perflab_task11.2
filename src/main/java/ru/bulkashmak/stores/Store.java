package ru.bulkashmak.stores;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.bulkashmak.Box;
import ru.bulkashmak.food.Fruit;
import ru.bulkashmak.food.GreenFood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    static final Logger LOGGER = LogManager.getRootLogger();

    public StoreBrand brand;
    public int id = 0;
    public List<Box<GreenFood>> localStorage;
    public HashMap<String, Integer> storageStatistics;

    public Store(StoreBrand brand) {
        this.brand = brand;
        this.id = (int) (Math.random() * 1000000);
        this.localStorage = new ArrayList<>();
        this.storageStatistics = new HashMap<>();
    }

    public List<Box<GreenFood>> getLocalStorage() {
        return localStorage;
    }

    public List<Box<GreenFood>> sortByPrice() {

        LOGGER.debug("Local Storage sorted by Price");
        return localStorage.stream()
                .sorted( (o1, o2) -> (int) Math.round(o1.getFood().getPrice() - o2.getFood().getPrice()) )
                .collect(Collectors.toList());
    }

    public List<Box<GreenFood>> sortByMassDesc() {

        LOGGER.debug("Local Storage sorted by Mass");
        return localStorage.stream()
                .sorted( (o1, o2) -> (int) Math.round(o2.getFood().getMass() - o1.getFood().getMass()) )
                .collect(Collectors.toList());
    }

    public int calcTotalPrice() {

        int total = localStorage.stream()
                .mapToInt( p -> (int) (p.getFood().getPrice()))
                .sum();

        LOGGER.debug("Calculated total Price: " + total);
        return total;
    }

    public int calcAllFruitsUnder50() {

        int totalUnder50 = localStorage.stream()
                .filter( p -> p.getFood().getClass().equals(Fruit.class))
                .filter( p -> p.getFood().getPrice() < 50 )
                .mapToInt( p -> (int) (p.getFood().getPrice()))
                .sum();

        LOGGER.debug("Calculeted total price for Fruits with a price under 50: " + totalUnder50);
        return totalUnder50;
    }

    public HashMap<String, Double> mappingVeggieToTotalMass() {

        HashMap<String, Double> map = new HashMap<>();

        for (Box<GreenFood> box : localStorage) {
            String key = box.getFood().toString();
            double weight = box.getFood().getMass();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + weight);
            }
            else {
                map.put(box.getFood().toString(), box.getFood().getMass());
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return id + "|" + brand;
    }
}
