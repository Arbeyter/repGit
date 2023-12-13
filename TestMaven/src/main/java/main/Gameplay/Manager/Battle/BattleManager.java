package main.Gameplay.Manager.Battle;
import main.Entity.Enemy;
import main.Entity.Entity;

import java.util.ArrayList;

public class BattleManager {
    Entity enemy;
    Entity player;
    boolean statusOfEnemy;
    public BattleManager(Entity entity1, Entity entity2){
        this.enemy = entity1;
        this.player = entity2;
    }
    public void attack(Entity entity){
        entity.editHealth(-1);
    }
    public FightStatus checkStatus(){
        if (enemy.getHealth() <= 0 && player.getHealth() <= 0) return FightStatus.DRAW;
        if (enemy.getHealth() <= 0) return FightStatus.WIN_PLAYER;
        if (player.getHealth() <= 0) return  FightStatus.WIN_ENEMY;

        return FightStatus.CONTINUE;
    }
    public String getStatus(){
        StringBuilder statusFight = new StringBuilder();
        statusFight.append("Ваши HP: " + player.getHealth() + '\n');
        statusFight.append(enemy.getName() + "HP: " + enemy.getHealth() + '\n');

        return statusFight.toString();
    }
    public ArrayList<FightVariants> getVariants(){
        ArrayList<FightVariants> listVariants = new ArrayList<FightVariants>();
        listVariants.add(FightVariants.ATTACK);
        listVariants.add(FightVariants.HEAL);
        listVariants.add(FightVariants.LEAVE);

        return listVariants;
    }
    public void inputDataPlayer(FightVariants act) {
        switch (act) {
            case ATTACK:
                enemy.editHealth(-1);
                break;
            case HEAL:
                player.editHealth(2);
                break;
            case LEAVE:
                player.editHealth(-999_999_999);
                break;
            default:
                break;
        }
    }

//    public FightStatus cycle(){
//        while (checkStatus() == FightStatus.CONTINUE){
//            ArrayList<FightVariants> listVariants = new ArrayList<FightVariants>();
//            listVariants.add(FightVariants.ATTACK);
//            listVariants.add(FightVariants.HEAL);
//            listVariants.add(FightVariants.LEAVE);
//        }
//
//    }

}
