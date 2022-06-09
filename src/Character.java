import java.lang.Math;
import java.util.ArrayList;


public abstract class Character implements Killable {
    //FIELDS
    private String name;
    private long hp;
    private int vitality;
    private int strength;
    private int intelligence;
    private IWeaponManager weapon;
    private Clothing clothing;
    private ArrayList<Item> inventory;
    private int state;



    //CONSTRUCTORS + GET-SET
    public Character(){
        inventory = new ArrayList<Item>();
        state = 2;//ALIVE
        clothing = new Clothing(0);

    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getHp() {
        return hp;
    }


    public void setHp(long hp) {
        this.hp = hp;
    }


    public int getVitality() {
        return vitality;
    }


    public void setVitality(int vitality) {
        this.vitality = vitality;
    }


    public int getStrength() {
        return strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public IWeaponManager getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //METHODS

    public long calculateHp(){
        if (Math.round(2*getVitality()+0.5*getIntelligence()+0.8*getStrength())>35){
            return 35;
        }else{
            return  Math.round(2*getVitality()+0.5*getIntelligence()+0.8*getStrength());
        }
    }

    public boolean checkWeight(int weightValue){
        int sum = weightValue;
        for (Item item :inventory){
            sum+= item.getWeight();
        }

        if (sum>strength*5){
            return false;
        }else{
            return true;
        }
    }





    public boolean pick(Item pickedItem){

        if (checkWeight(pickedItem.getWeight())){
            inventory.add(pickedItem);
            System.out.println(getName()+" picked the "+pickedItem.getName()+ " successfully.");
            return true;
        }else{
            System.out.println("The strength limit has been reached this character cant carry no more item.");
            return false;
        }

    }

    public boolean wield(ArrayList<Item> groundInv,String[]userInput){
        for (Item item: groundInv){
            if (item.getName().equals(userInput[2])&& item instanceof Weapon){
                if (checkWeight(item.getWeight())){
                    inventory.add(weapon);
                }else {
                    System.out.println("The old weapon cannot be added to inventory so it has been thrown away.");
                }

                weapon = (Weapon) item;
                return true;
            }
        }

        for (Item item: inventory){
            if (item.getName().equals(userInput[2])&& item instanceof Weapon){
                if (checkWeight(item.getWeight())){
                    inventory.add(weapon);
                }else {
                    System.out.println("The old weapon cannot be added to inventory so it has been thrown away.");
                }
                weapon = (Weapon) item;
                return false;
            }
        }

        return false;


    }

    public boolean wear(ArrayList<Item> groundInv, String[] userInput){
        for (Item item: groundInv){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                if (checkWeight(item.getWeight())){
                    inventory.add(clothing);
                }else {
                    System.out.println("The old clothing cannot be added to inventory so it has been thrown away.");
                }
                clothing = (Clothing) item;
                return true;
            }
        }

        for (Item item: inventory){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                if (checkWeight(item.getWeight())){
                    inventory.add(clothing);
                }else {
                    System.out.println("The old clothing cannot be added to inventory so it has been thrown away.");
                }
                clothing = (Clothing) item;
                return false;
            }
        }

        return false;



    }




    public void attack(Character selectedCharacter){

        if (getWeapon() != null&&state !=0) {
            int dmg = getWeapon().calculateDmg(this);
            selectedCharacter.setHp(selectedCharacter.hp - (long) dmg + selectedCharacter.clothing.getResistance());
            if (selectedCharacter.hp < 0) {
                selectedCharacter.hp = 0;
            }
            System.out.println(getName() + " does " + dmg + " damage. " + selectedCharacter.name + " has " + selectedCharacter.hp + " HP left.");
        }else{
            System.out.println("This Character cannot attack.");
        }


    }

    public abstract Item createWeapon(ArrayList<Item> allWeapons);


    public void listInventory(){
        System.out.println("Inventory: ");
        for (Item item:getInventory()){
            System.out.println(item.getName());
        }
        System.out.println("********************");
    }

    @Override
    public boolean checkDeath() {
        if (hp==0){
            return true;
        }else {
            return false;
        }
    }
}