package ru.bulkashmak;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.bulkashmak.food.*;
import ru.bulkashmak.stores.Store;
import ru.bulkashmak.stores.StoreDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GreenFoodBase {

    static final Logger LOGGER = LogManager.getRootLogger();

    List<Box<GreenFood>> baseStorage;

    public void initializeStartingSupplies(){

        generateGreenFoods().stream().map((g)->{
            Random random = new Random();
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            return new Box(randomStore.id, randomStore.brand, g);
        });
    }

    public List<GreenFood> generateGreenFoods(){
        List<GreenFood> generatedFood = new ArrayList<>();

        Random random = new Random();
        int greenFoodsCount = random.nextInt(30) + 30;

        for(int i=0; i<greenFoodsCount; i++) {
            int greenFoodChoice = random.nextInt(4);
            double price = random.nextDouble() * 30 + 10;
            double mass = random.nextDouble() * 5 + 20;

            GreenFood greenFood;
            switch (greenFoodChoice) {
                case 0:
                    greenFood = new Apple(price, mass);
                    LOGGER.debug("Created an Apple with a price=["+price+"] and mass=["+mass+"]");
                    break;
                case 1:
                    greenFood = new Banana(price, mass);
                    LOGGER.debug("Created a Banana with a price=["+price+"] and mass=["+mass+"]");
                    break;
                case 2:
                    greenFood = new Cabbage(price, mass);
                    LOGGER.debug("Created a Cabbage with a price=["+price+"] and mass=["+mass+"]");
                    break;
                default:
                    greenFood = new Potato(price, mass);
                    LOGGER.debug("Created a Potato with a price=["+price+"] and mass=["+mass+"]");
                    break;
            }
            generatedFood.add(greenFood);
        }

        return generatedFood;
    }
}
