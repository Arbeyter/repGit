package main.Gameplay.Frames;
import main.Entity.Enemy;

import main.Gameplay.TypeFrame;

import java.util.List;

public class FrameFight extends Frame{
    Enemy enemy;
    List<Frame> warVariants;

    public Enemy getEnemy() {
        return enemy;
    }

    public FrameFight(String name, Enemy enemy){
        super(name, String.format("%s %s", "На вашем пути встречается..", enemy.getName()));
        this.enemy = enemy;
        this.typeAct = TypeFrame.FIGHT;
    }
    public boolean getStatus(){
        if (enemy.getHealth()<=0){
            return false;
        }
        return true;
    }
//    @Override
//    public List<Frame> getVariants(){
//        if (enemy.getHealth()<=0){
//            return variants;
//        }
//        return warVariants;
//    }

    public int attack(){
        int damage = 3;
        enemy.editHealth(damage);
        return damage;
    }

    @Override
    public String getText() {
        return super.getText() + "\n"+"Здоровье "+enemy.getName()+": "+ enemy.getHealth();
    }
}
