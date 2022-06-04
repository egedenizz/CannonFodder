package Item;

import Character.Character;


public class Shield extends Weapon{

     private int leftChancesToStun;

    public Shield(){

    }

    public Shield(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
    }


    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getVitality();
    }




    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {
        if (leftChancesToStun>0){
            selectedTarget.setState(1);
        }else {
            System.out.println("This character cannot stun anymore.");
        }
        leftChancesToStun--;
    }



}
