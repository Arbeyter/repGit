package main;

import main.Entity.Enemy;
import main.Gameplay.Frames.Frame;
import main.Gameplay.Frames.FrameFight;
import main.Gameplay.Gameplay;
import main.UI.Cons;

import main.Gameplay.*;
import main.Entity.*;

import main.Gameplay.Frames.FrameLocation;


public class Main {
    public static void main(String[] args) {
        Entity player = new Entity("Игрок", 20);

        Enemy zombie = new Enemy("зомби",10);
        Enemy bomzh = new Enemy("бомж", 5);
        Enemy bird = new Enemy("голубь", 1);

        Frame start = new FrameLocation("Start","Начало");
        Frame alleyway = new FrameFight("Подворотня", bomzh);
        Frame parkWay = new FrameFight("Дорожка без освещения", bird);

        Frame street = new FrameLocation("Улица","Вы видите перед собой шаурмячную");
        Frame rsreu = new FrameLocation("РГРТУ", "Смутное знакомое здание");
        Frame park = new FrameLocation("ЦПКиО", "Ни культуры, ни отдыха");

        start.setVariants(alleyway, street);
        alleyway.setVariants(street);
        street.setVariants(alleyway, park, rsreu);
        rsreu.setVariants(street, park);
        park.setVariants(street, parkWay);
        parkWay.setVariants(park);




        //основной цикл
        Gameplay game = new Gameplay(player, start);
        //Cons cons = new Cons(game);
        while (true){
            game.step();
        }

    }


}