package Main;

import Item.*;
import Character.*;
import  Character.Character;
import Item.Item;


import java.security.SecureRandom;
import java.util.ArrayList;


public class Level {
    private ArrayList<Item> ground;
    private int levelNum;
    private int enemyNum;
    private ArrayList<Item> allItems;
    private ArrayList<Character> characters;
    private ArrayList<Enemy> enemies;

    public Level(){
        this.ground = new ArrayList<Item>();
    }

    public Level(ArrayList<Item> ground, ArrayList<Character> characters, ArrayList<Enemy> enemies) {
        this.ground = new ArrayList<Item>();
        this.characters = characters;
        this.enemies = enemies;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public  int getEnemyNum() {
        return enemyNum;
    }

    public void setEnemyNum(int enemyNum) {
        this.enemyNum = enemyNum;
    }

    public ArrayList<Item> getGround() {
        return ground;
    }

    public void setGround(ArrayList<Item> ground) {
        this.ground = ground;
    }


    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<Item> allItem) {
        allItems = allItem;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }






    public Character selectChar(String[] userInput,ArrayList<Character>characters){
        for(Character character: characters){
            if (character.getName().equals(userInput[0])&& characters.indexOf(character)<4){
                return character;
            }
        }

        return null;

    }

    public Character selectTarget(String[] userInput,ArrayList<Character> characters){
        for (Character target:characters){
            if (target.getName().equals(userInput[2])){
                return target;
            }
        }

        return null;

    }

    public Item selectItem(String[] userInput,Character selectedCharacter){
        ArrayList<Item> tempList = new ArrayList<Item>();
        tempList.addAll(ground);
        tempList.addAll(selectedCharacter.getInventory());
        tempList.add(selectedCharacter.getWeapon());
        tempList.add(selectedCharacter.getClothing());
        for (Item item: tempList){


            try {
                if (item.getName().equals(userInput[2])) {
                    return item;
                }
            }catch (NullPointerException ignored){

            }


        }

        return null;
    }


    public Item selectRandomItem() {
        SecureRandom secureRandom = new SecureRandom();

        int randomNum = secureRandom.nextInt(allItems.size());
        for (Item item : allItems) {
            if(randomNum == allItems.indexOf(item)&& item instanceof Sword){
                return item;
            }

        }
        return null;



    }


    public void display(ArrayList<Character>characters){
        System.out.print("\nCreating Level "+levelNum+", with "+enemyNum+" enemy soldiers.\nEntering level "+enemyNum+ "; ");
        for (Character character: characters){
            if (character.getState() == 2){
                System.out.print(character.getName()+" enters.");
            }
        }
        System.out.println();

    }

    public void groundAdd(Item item){
        ground.add(item);
    }

    public void groundRemove(Item item){
        ground.remove(item);
    }

    public void allItemsAdd(Item item){
        allItems.add(item);
    }

    public void allItemsRemove(Item item){
        allItems.remove(item);
    }









}
