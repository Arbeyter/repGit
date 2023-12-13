package Tests.Gameplay;

import org.testng.Assert;
import org.testng.annotations.Test;
import main.Gameplay.Frames.Frame;
import main.Gameplay.Frames.FrameLocation;
import main.Gameplay.Manager.Battle.BattleManager;
import main.Entity.Entity;
import main.Gameplay.Manager.Battle.FightStatus;
import main.Gameplay.Manager.Battle.FightVariants;
import main.Gameplay.Gameplay;
//import main.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class GameplayTest {

    @Test
    public void test_FightStatus() {
        Entity player = new Entity("first",10);
        Entity enemy = new Entity("second",5);
        BattleManager battleManager = new BattleManager(enemy, player);
        Assert.assertNotNull(battleManager.checkStatus());
    }

    @Test
    public void test_PickVar() {
        Entity player = new Entity("player",20);
        Frame frame = new FrameLocation("name", "description");
        Frame frame2 = new FrameLocation("test", "description");
        frame.setVariants(frame2);
        Gameplay gameplay = new Gameplay(player, frame);
        gameplay.pickVar(0);
        Assert.assertNotNull(gameplay.getCurrentFrame());
    }

//    @Test
//    public void testStep() {
//        Entity player = new Entity("player",100);
//        Frame frame = new FrameLocation("arena", "arena");
//        Gameplay gameplay = new Gameplay(player, frame);
//        
//        Assert.assertNotNull(gameplay.getNextFrame());
//    }
//    @Test
//    public void test_Fight() {
//        Entity player = new Entity();
//        Frame frame = new FrameLocation("name", "description");
//        Gameplay gameplay = new Gameplay(player, frame);
//        FightStatus actualStatus = gameplay.fight();
//        Assert.assertTrue(actualStatus == FightStatus.DRAW || actualStatus == FightStatus.WIN_ENEMY || actualStatus == FightStatus.WIN_PLAYER);
//    }

    @Test
    public void test_PickVar2() {
        Entity player = new Entity();
        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(new FrameLocation("123", null));
        frames.add(new FrameLocation("456", null));
        frames.add(new FrameLocation("789", null));
        Frame currentFrame = new FrameLocation("Location", null);
        Gameplay gameplay = new Gameplay(player, currentFrame);
        currentFrame.setVariants(frames);
        int variant = 2;
        gameplay.pickVar(variant);
        Assert.assertEquals(gameplay.getCurrentFrame(), frames.get(variant));
    }
//
    @Test
    public void test_GetNextFrame() {
        Entity player = new Entity();
        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(new FrameLocation("123", null));
        frames.add(new FrameLocation("456", null));
        frames.add(new FrameLocation("789", null));
        Frame currentFrame = new FrameLocation("Location", null);
        currentFrame.setVariants(frames);
        Gameplay gameplay = new Gameplay(player, currentFrame);
        gameplay.setNextFrame(frames);
        
        
        Assert.assertEquals(gameplay.getNextFrame(), frames);
}
    }
