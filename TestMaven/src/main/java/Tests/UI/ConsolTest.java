package Tests.UI;

import main.Gameplay.Frames.FrameLocation;
import main.Entity.Enemy;
import main.Entity.Entity;
import main.Gameplay.Gameplay;
import main.UI.Cons;
import main.Gameplay.Frames.Frame;
import main.Gameplay.Frames.FrameFight;
import main.Gameplay.Manager.Battle.FightVariants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class ConsolTest {

    private Gameplay game;



    @AfterMethod
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void test_Visualize() {

    }

    @Test
    public void test_UserInput() {
        String simulatedInput = "3\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = Cons.userInput(3);

        Assert.assertEquals(result, 2); 
    }

    @Test
    public void test_PrintVariants_FightVariants() {
        ArrayList<FightVariants> fightVariants = new ArrayList<>();
        fightVariants.add(FightVariants.ATTACK);
        fightVariants.add(FightVariants.HEAL);
        fightVariants.add(FightVariants.LEAVE);


        String expectedOutput = "1. Attack\n2. Heal\n3. Leave\n";

        InputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        Cons.printVariants(fightVariants);

        Assert.assertEquals(System.out.toString(), expectedOutput);
    }

    @Test
    public void test_PrintVariants_Gameplay() {
        Frame frame1 = new FrameLocation("Frame 1", "Description 1");
        Frame frame2 = new FrameLocation("Frame 2", "Description 2");
        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        game.setNextFrame(frames);



        String expectedOutput = "1. Frame 1\n2. Frame 2\n";

        InputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        Cons.printVariants(game);

        Assert.assertEquals(System.out.toString(), expectedOutput);
    }

    @Test
    public void test_StepWalk() {
    	Entity player = new Entity("Игрок", 20);

        Enemy zombie = new Enemy("зомби",10);
        Enemy bomzh = new Enemy("бомж", 5);
        Enemy bird = new Enemy("голубь", 1);

        Frame start = new FrameLocation("Start","Начало");
        Frame alleyway = new FrameFight("Подворотня", bomzh);


        start.setVariants(alleyway);

        
        Gameplay game = new Gameplay(player, start);
        Cons cons = new Cons(game);

        Cons.stepWalk(game);
        
        Assert.assertEquals(game.getCurrentFrame(), alleyway);
 

    }

    @Test
    public void test_StepBattle() {
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
        
        Gameplay game = new Gameplay(player, start);
        Cons cons = new Cons(game);
        
        cons.stepBattle(game);
    }
}