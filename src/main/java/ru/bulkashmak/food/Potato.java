package ru.bulkashmak.food;

public class Potato extends Vegetable {

    public Potato(double price, double mass) {
        super(price, mass);
    }

    @Override
    public String toString() {
        return "Potato";
    }
}
