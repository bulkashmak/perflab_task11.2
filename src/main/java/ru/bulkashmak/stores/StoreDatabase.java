package ru.bulkashmak.stores;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreDatabase {

    static final Logger LOGGER = LogManager.getRootLogger();

    public static List<Store> allStores;

    public static void generateStores(){
        allStores = new ArrayList<>();

        Random random = new Random();
        int storesCount = random.nextInt(5) + 1;
        for(int i = 0; i<storesCount; i++){
            int storeBrandIndex = random.nextInt(StoreBrand.values().length);

            allStores.add(new Store(StoreBrand.values()[storeBrandIndex]));

            LOGGER.info("Added store [" + StoreBrand.values()[storeBrandIndex] + "] to allStores list");
        }
        LOGGER.debug("Created "+storesCount+" stores");
    }
}
