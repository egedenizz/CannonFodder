
import Item.*;
import Character.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item>generaInv = new ArrayList<Item>();
        generaInv.add(new Sword("asd",23,23));
        generaInv.add(new Sword("exca",434,123));
        generaInv.add(new Wand());
        generaInv.add(new Shield());

        Fighter fighter = new Fighter(generaInv);

        System.out.println(fighter.getWeapon().getName());

        ArrayList<Item> FighterInv = new ArrayList<>();
        FighterInv.add(new Sword("asd",23,23));
        FighterInv.add(new Shield("exca",434,123));
        FighterInv.add(new Wand("Merhaba",45,245));
        Fighter fighter2 = new Fighter(FighterInv);
        fighter2.selectRandomItem(FighterInv);
        System.out.println(fighter2.getWeapon().getName());








    }
}
