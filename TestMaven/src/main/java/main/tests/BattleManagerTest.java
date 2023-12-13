package main.tests;

import main.Entity.Entity;
import main.Gameplay.Manager.Battle.BattleManager;
import main.Gameplay.Manager.Battle.FightStatus;
import main.Gameplay.Manager.Battle.FightVariants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BattleManagerTest {

    private Entity enemy;
    private Entity player;
    private BattleManager battleManager;

    @BeforeMethod
    public void setUp() {
        enemy = new Entity("Enemy", 10);
        player = new Entity("Player", 10);
        battleManager = new BattleManager(enemy, player);
    }

    @Test
    public void testAttack() {
        int initialHealth = enemy.getHealth();
        battleManager.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), initialHealth - 1);
    }

    @Test
    public void testCheckStatus_Draw() {
        enemy.editHealth(-10);
        player.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.DRAW);
    }

    @Test
    public void testCheckStatus_WinEnemy() {
        enemy.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_ENEMY);
    }

    @Test
    public void testCheckStatus_WinPlayer() {
        player.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_PLAYER);
    }

    @Test
    public void testCheckStatus_Continue() {
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.CONTINUE);
    }

    @Test
    public void testGetStatus() {
        String expectedStatus = "Ваши HP: 10\nEnemyHP: 10\n";
        Assert.assertEquals(battleManager.getStatus(), expectedStatus);
    }

    @Test
    public void testGetVariants() {
        ArrayList<FightVariants> expectedVariants = new ArrayList<>();
        expectedVariants.add(FightVariants.ATTACK);
        expectedVariants.add(FightVariants.HEAL);
        expectedVariants.add(FightVariants.LEAVE);

        Assert.assertEquals(battleManager.getVariants(), expectedVariants);
    }

    @Test
    public void testInputDataPlayer_Attack() {
        int initialEnemyHealth = enemy.getHealth();
        battleManager.inputDataPlayer(FightVariants.ATTACK);
        Assert.assertEquals(enemy.getHealth(), initialEnemyHealth - 1);
    }

    @Test
    public void testInputDataPlayer_Heal() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.HEAL);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth + 2);
    }

    @Test
    public void testInputDataPlayer_Leave() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.LEAVE);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth - 999_999_999);
    }
}
