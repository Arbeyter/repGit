package main.UI;

import main.Gameplay.Gameplay;
import main.Gameplay.Frames.Frame;
import main.Gameplay.Manager.Battle.FightStatus;
import main.Gameplay.Manager.Battle.FightVariants;

import java.util.ArrayList;
import java.util.Scanner;

public class Cons {
    Gameplay game;

    public Cons(Gameplay game) {
        this.game = game;
    }

    static public void visualize(Gameplay game) {
        System.out.println("=============");
//        System.out.println(game.getCurrentFrame().getTypeAct());
//        System.out.println(game.getCurrentFrame().getName());
//        System.out.println(game.getCurrentFrame().getDescription());
            System.out.println(game.getCurrentFrame().getText());
    }

    static public int userInput(int limit) {
        System.out.print("Ваше действие: ");
        Scanner in = new Scanner(System.in);
        int output;
        boolean checkVarFalse;
        do {
            output = in.nextInt();
            checkVarFalse = !(0 < output & output <= limit);
            if (checkVarFalse){
                System.out.println("Некорректный ввод.");
            }
        } while (checkVarFalse);
        return output-1;

    }
    static public void printVariants(ArrayList<FightVariants> fightVariants) {
        int i = 1;
        for (FightVariants variant :  fightVariants) {
            System.out.println(String.format("%d. %s",i++,variant.getAct()));
        }
        //return  fightVariants.getNextFrame().size();
    }
    static public int printVariants(Gameplay game) {
        int i = 1;
        for (Frame frame : game.getNextFrame()) {
            System.out.println(String.format("%d. %s",i++,frame.getName()));
        }
        return game.getNextFrame().size();
    }

    static public void stepWalk(Gameplay game) {
        visualize(game);
        int lenVars = printVariants(game);
        int pick = userInput(lenVars);
        game.pickVar(pick);
    }
    static public void stepBattle(Gameplay game){
        visualize(game);

    }
}
