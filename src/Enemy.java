import java.security.SecureRandom;
import java.util.ArrayList;


public class Enemy extends Character {

    public Enemy(ArrayList<Item> allItems){
        SecureRandom secureRandom = new SecureRandom();

        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+1);
        setWeapon(createWeapon(allItems));
        setHp(calculateHp());
    }


    @Override
    public void attack(Character selectedCharacter) {
        if (getState()!=1){

            int dmg = getWeapon().calculateDmg(this);
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            if (selectedCharacter.getHp()<0){
                selectedCharacter.setHp(0);
            }
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }

    @Override
    public Weapon createWeapon(ArrayList<Item> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        int randomNum = secureRandom.nextInt(10)+1;

        if (randomNum<=8){
            return (Weapon) new Sword().generateItem(allItems);
        }else if ((randomNum==9)){
            return (Weapon) new Wand().generateItem(allItems);
        }else{
            return (Weapon) new Shield().generateItem(allItems);
        }

    }



}