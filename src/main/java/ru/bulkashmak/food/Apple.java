package ru.bulkashmak.food;

public class Apple extends ru.bulkashmak.food.Fruit {

    public Apple(double price, double mass) {
        super(price, mass);
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
