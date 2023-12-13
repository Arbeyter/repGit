package Tests.Manager.ManagerBattle;

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
    public void test_Attack() {
        int initialHealth = enemy.getHealth();
        battleManager.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), initialHealth - 1);
    }

    @Test
    public void test_CheckStatus_Draw() {
        enemy.editHealth(-20);
        player.editHealth(-20);
        battleManager.attack(enemy);
        battleManager.attack(player);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.DRAW);
    }

    @Test
    public void test_CheckStatus_WinPlayer() {
        enemy.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_PLAYER);
    }

    @Test
    public void test_CheckStatus_WinEnemy() {
        player.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_ENEMY);
    }

    @Test
    public void test_CheckStatus_Continue() {
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.CONTINUE);
    }

    @Test
    public void test_GetStatus() {
        String expectedStatus = "Ваши HP: 10\nEnemyHP: 10\n";
        Assert.assertEquals(battleManager.getStatus(), expectedStatus);
    }

    @Test
    public void test_GetVariants() {
        ArrayList<FightVariants> expectedVariants = new ArrayList<>();
        expectedVariants.add(FightVariants.ATTACK);
        expectedVariants.add(FightVariants.HEAL);
        expectedVariants.add(FightVariants.LEAVE);

        Assert.assertEquals(battleManager.getVariants(), expectedVariants);
    }

    @Test
    public void test_InputDataPlayer_Attack() {
        int initialEnemyHealth = enemy.getHealth();
        battleManager.inputDataPlayer(FightVariants.ATTACK);
        Assert.assertEquals(enemy.getHealth(), initialEnemyHealth - 1);
    }

    @Test
    public void test_InputDataPlayer_Heal() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.HEAL);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth + 2);
    }

    @Test
    public void test_InputDataPlayer_Leave() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.LEAVE);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth - 999_999_999);
    }
    
    @Test
    public void test_InputDataPlayer_InvalidAction() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.BLOCK);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth);
    }

    @Test
    public void test_InputDataPlayer_InvalidActionLeave() {
        int initialPlayerHealth = player.getHealth();
        battleManager.inputDataPlayer(FightVariants.LEAVE);
        int actualValue = player.getHealth();
        Assert.assertTrue(actualValue >0);
    }

    @Test
    public void test_CheckStatus_BothZeroHealth() {
        enemy.editHealth(-10);
        player.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.DRAW);
    }

    @Test
    public void test_InputDataPlayer_MultipleActions() {
        int initialEnemyHealth = enemy.getHealth();
        int initialPlayerHealth = player.getHealth();
        
        battleManager.inputDataPlayer(FightVariants.ATTACK);
        battleManager.inputDataPlayer(FightVariants.HEAL);
        battleManager.inputDataPlayer(FightVariants.LEAVE);

        Assert.assertEquals(enemy.getHealth(), initialEnemyHealth - 1);
        Assert.assertEquals(player.getHealth(), initialPlayerHealth + 2 - 999_999_999);
    }

    @Test
    public void test_Cycle_CheckStatus() {
        enemy.editHealth(-10);
        player.editHealth(-10);
        //battleManager.cycle();
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.DRAW);
    }
    
    @Test
    public void test_Attack_LowerEnemyHealth() {
        int initialHealth = enemy.getHealth();
        //enemy.editHealth(-1);
        battleManager.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), initialHealth - 1);
    }

    @Test
    public void test_Attack_NegativeEnemyHealth() {
    	int initialHealth = enemy.getHealth();
        enemy.editHealth(-1);
        //battleManager.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), initialHealth - 1);
    }

    @Test
    public void test_CheckStatus_WinPlayerNegativeEnemyHealth() {
        enemy.editHealth(-1000);
        player.editHealth(10);
        battleManager.attack(enemy);
        //battleManager.
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_PLAYER);
    }

    @Test
    public void test_CheckStatus_WinPlayerNegativePlayerHealth() {
        enemy.editHealth(10);
        player.editHealth(-10);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.WIN_ENEMY);
    }

    @Test
    public void test_CheckStatus_ContinuePlayerNegativeHealth() {
        player.editHealth(100000);
        enemy.editHealth(100000);
        Assert.assertEquals(battleManager.checkStatus(), FightStatus.CONTINUE);
    }

    @Test
    public void test_GetStatus_PlayerNegativeHealth() {
        player.editHealth(-10);
        String expectedStatus = "Ваши HP: 0\nEnemyHP: 10\n";
        Assert.assertEquals(battleManager.getStatus(), expectedStatus);
    }

//    @Test
//    public void testGetVariants_PlayerNegativeHealth() {
//        player.editHealth(-10);
//        battleManager.attack(player);
//        ArrayList<FightVariants> expectedVariants = new ArrayList<>();
//        expectedVariants.add(FightVariants.LEAVE);
//
//        Assert.assertEquals(battleManager.getVariants(), expectedVariants.get(0));
//    }


}
