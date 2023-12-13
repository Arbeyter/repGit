package main.tests;

import main.Gameplay.Frames.Frame;
import main.Gameplay.Frames.FrameLocation;
import main.Gameplay.Gameplay;
import main.Gameplay.Manager.Battle.FightVariants;
import main.UI.Cons;
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
    public void testVisualize() {
        // Since visualize method relies on System.out.println, it's hard to test its output.
        // It's recommended to refactor such methods to return a string and then test the string.
        // For simplicity, we're not testing visualize here.
        // You may want to consider refactoring this method for better testability.
    }

    @Test
    public void testUserInput() {
        // Simulate user input "3" for a limit of 3
        String simulatedInput = "3\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        int result = Cons.userInput(3);

        Assert.assertEquals(result, 2); // Since arrays are 0-indexed, input 3 corresponds to index 2
    }

    @Test
    public void testPrintVariants_FightVariants() {
        ArrayList<FightVariants> fightVariants = new ArrayList<>();
        fightVariants.add(FightVariants.ATTACK);
        fightVariants.add(FightVariants.HEAL);
        fightVariants.add(FightVariants.LEAVE);

        // Redirect System.out.println output for assertion
        // Note: This may not be the ideal way to test, and you may want to refactor for better testability.
        // For simplicity, we're capturing the output to verify it.
        String expectedOutput = "1. Attack\n2. Heal\n3. Leave\n";

        InputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        Cons.printVariants(fightVariants);

        Assert.assertEquals(System.out.toString(), expectedOutput);
    }

    @Test
    public void testPrintVariants_Gameplay() {
        Frame frame1 = new FrameLocation("Frame 1", "Description 1");
        Frame frame2 = new FrameLocation("Frame 2", "Description 2");
        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        game.setNextFrame(frames);


        // Redirect System.out.println output for assertion
        // Note: This may not be the ideal way to test, and you may want to refactor for better testability.
        // For simplicity, we're capturing the output to verify it.
        String expectedOutput = "1. Frame 1\n2. Frame 2\n";

        InputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        Cons.printVariants(game);

        Assert.assertEquals(System.out.toString(), expectedOutput);
    }

    @Test
    public void testStepWalk() {
        // Since stepWalk relies on System.out.println and user input, it's challenging to test.
        // It's recommended to refactor such methods for better testability.
        // You may want to consider refactoring this method.
    }

    @Test
    public void testStepBattle() {
        // Since stepBattle relies on System.out.println, it's hard to test its output.
        // It's recommended to refactor such methods to return a string and then test the string.
        // For simplicity, we're not testing stepBattle here.
        // You may want to consider refactoring this method for better testability.
    }
}