package ru.bulkashmak.food;

public class Banana extends ru.bulkashmak.food.Fruit {

    public Banana(double price, double mass) {
        super(price, mass);
    }

    @Override
    public String toString() {
        return "Banana";
    }
}
