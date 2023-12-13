package main.tests;

import main.Files.Filer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FilerTest {

    @Test
    public void testReadFileLines() {
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("first line");
        expectedList.add("second line");
        expectedList.add("third line");

        ArrayList<String> actualList = Filer.ReadFileLines("test.txt");

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testGetRandomString() {
        ArrayList<String> listStrings = new ArrayList<String>();
        listStrings.add("rsc/items/name_clothes.txt");
        listStrings.add("rsc/items/name_items.txt");
        listStrings.add("rsc/items/name_weapone.txt");

        for(String path: listStrings) {
            String randomString = Filer.getRandomString(path);
            Assert.assertNotNull(randomString.toString());
        }
    }
}