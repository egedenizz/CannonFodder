import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Character {




    public Fighter(ArrayList<Item> allItems){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setWeapon(createWeapon(allItems));
        setHp(calculateHp());
        System.out.print("Fighter created with S: " + getStrength() + ", V: " + getVitality() + ", I: " + getIntelligence() + ", The HP is: " + getHp() + ". Fighter wields " );
        getWeapon().display();
    }

    public Fighter(){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setInventory(new ArrayList<Item>());
    }



    @Override
    public Weapon createWeapon(ArrayList<Item> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (Item item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Sword) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }


}
