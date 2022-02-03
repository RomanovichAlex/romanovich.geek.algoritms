package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> bestItems = null;

    private double maxWeigth;
    private double bestPrice;

    //Вес предметов
    private double calculateWeigthItems(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getWeigth();
        }
        return result;
    }

    // Стоимость предметов
    private double calculatePriceItems(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getPrice();
        }
        return result;
    }

    //Лучший ли набор предметов
    private void optimalRatio(List<Item> items) {
        if (this.bestItems == null) {
            if (this.calculateWeigthItems(items) <= this.maxWeigth) {
                this.bestItems = items;
                this.bestPrice = this.calculatePriceItems(items);
            }
        } else {
            if (this.calculateWeigthItems(items) <= this.maxWeigth && this.calculatePriceItems(items) > this.bestPrice) {
                this.bestItems = items;
                this.bestPrice = this.calculatePriceItems(items);
            }
        }
    }

    //Делаем все перестановки
    public void shufflingItems(List<Item> items) {
        if (items.size() > 0) {
            this.optimalRatio(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            shufflingItems(newSet);
        }
    }
    public Backpack(double maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public double getBestPrice(){
        return this.bestPrice;
    }

    public List<Item> getBestItems() {
        return this.bestItems;
    }
}
