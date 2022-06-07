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
        if (Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength())>35){
            return 35;
        }else{
            return  Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength());
        }
    }



    public boolean pick(Item pickedItem){
        int sum = pickedItem.getWeight();
        for (Item item:getInventory()){
            sum += item.getWeight();

        }

        if (sum<=getVitality()*4){
            inventory.add(pickedItem);
            return true;
        }else{
            System.out.println("The character's weight limit has been reached. "+pickedItem.getName()+ "dropped.");
            return false;
        }

    }

    public void wield(String itemName, Level level){



    }

    public Item wear(ArrayList<Item> groundInv, String[] userInput){
        for (Item item: groundInv){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return item;
            }
        }

        for (Item item: inventory){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return null;
            }
        }

        return null;



    }




    public void attack(Character selectedCharacter){

        if (getWeapon() != null) {
            int dmg = getWeapon().calculateDmg(this);
            selectedCharacter.setHp(selectedCharacter.hp - (long) dmg + selectedCharacter.clothing.getResistance());
            if (selectedCharacter.hp < 0) {
                selectedCharacter.hp = 0;
            }
            System.out.println(getName() + " does " + dmg + " damage. " + selectedCharacter.name + " has " + selectedCharacter.hp + " HP left.");
        }else{
            System.out.println("This Character doesn't wield a weapon it cannot attack.");
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
