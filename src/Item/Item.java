package Item;

import Character.Character;
import Character.*;

public abstract class Item{
    private String name;
    private int value;
    private int weight;


    public Item(){

    }

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract void display();






}
