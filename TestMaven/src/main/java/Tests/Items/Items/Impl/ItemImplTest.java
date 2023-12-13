package Tests.Items.Items.Impl;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.Files.Filer;
import main.Items.Items.Impl.*;
public class ItemImplTest {
    private ItemImpl item = new ItemImpl();

    @BeforeTest
    public void setUp() {
        item = new ItemImpl();
    }

    @Test
    public void test_Id_positive() {
    	//item = new ItemImpl();
        Assert.assertTrue(item.getId() >= 0);
    }

    @Test
    public void test_AdjectiveIsNotNull() {
        Assert.assertNotNull(item.getAdjective());
    }

    @Test
    public void test_NameIsNotEmpty() {
        Assert.assertFalse(item.name.isEmpty());
    }

    @Test
    public void test_InfoFormat() {
        String info = item.getInfo();
        String[] parts = info.split(" ");
        Assert.assertEquals(parts.length, 3);
        long id = Long.parseLong(parts[0]);
        Assert.assertTrue(id > 0);
    }
    
    @Test
    public void test_BuildAdjective() {
        ItemImpl item = new ItemImpl();
        Assert.assertNotNull(item.getAdjective());
        ArrayList<String> adjectives = Filer.ReadFileLines("src/rsc/adjective.txt");
        Assert.assertTrue(adjectives.contains(item.getAdjective()));
    }

    @Test
    public void test_GetInfo() { 
        ItemImpl item = new ItemImpl();
        String info = item.getInfo();
        Assert.assertTrue(info.contains(Long.toString(item.getId())));
        Assert.assertTrue(info.contains(item.getAdjective()));
        Assert.assertTrue(info.contains(item.name));
        ArrayList<String> adjectives = Filer.ReadFileLines("src/rsc/adjective.txt");
        Assert.assertTrue(adjectives.contains(item.getAdjective()));
}
    }