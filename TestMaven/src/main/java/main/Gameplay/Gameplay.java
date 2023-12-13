package main.Gameplay;
import main.Gameplay.Frames.Frame;
import main.Gameplay.Manager.Battle.BattleManager;
import main.Entity.Entity;
import main.Gameplay.Manager.Battle.FightStatus;
import main.Gameplay.Manager.Battle.FightVariants;
import main.UI.Cons;

import java.util.ArrayList;
import java.util.List;
public class Gameplay {
    Frame currentFrame;
    Entity player;
    List<Frame> nextFrame;
    public Gameplay(Entity player,Frame frame){
        currentFrame = frame;
        this.player = player;


    }
    public FightStatus fight(){
        BattleManager battleManager = new BattleManager(currentFrame.getEnemy(),player);
        while (battleManager.checkStatus() == FightStatus.CONTINUE){
            System.out.println(battleManager.getStatus());
            Cons.printVariants(battleManager.getVariants());
            int variant = Cons.userInput(3);
            battleManager.inputDataPlayer(FightVariants.values()[variant]);
        }
        return battleManager.checkStatus();
    }
    public void step(){
        switch (currentFrame.getTypeAct()){
            case LOCATION:
                nextFrame = currentFrame.getVariants();
                Cons.visualize(this);
                Cons.printVariants(this);
                pickVar(Cons.userInput(nextFrame.size()));
                break;
            case FIGHT:
                switch(fight()){
                    case CONTINUE ->{System.out.println("бой продолжается");}
                    case DRAW ->{System.out.println("Ничья");}
                    case WIN_ENEMY -> {System.out.println("Вы проиграли битву");}
                    case WIN_PLAYER -> {System.out.println("Вы победили!");}
                }
                nextFrame = currentFrame.getVariants();

                Cons.printVariants(this);
                pickVar(Cons.userInput(nextFrame.size()));



                break;
        }
    }
    public void pickVar(int p){
        currentFrame = currentFrame.getVariants().get(p);
    }
    public List<Frame> getNextFrame(){
        return currentFrame.getVariants();
    }
    public Frame getCurrentFrame(){
        return currentFrame;
    }

    public void setNextFrame(ArrayList<Frame> frames) {
    }
}
