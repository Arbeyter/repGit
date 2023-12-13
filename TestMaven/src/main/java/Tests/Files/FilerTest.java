package Tests.Files;

import org.testng.Assert;
import org.testng.annotations.Test;
import main.Files.Filer;
import java.util.ArrayList;

public class FilerTest {

    @Test
    public void test_ReadFileLines() {
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("first line");
        expectedList.add("second line");
        expectedList.add("third line");

        ArrayList<String> actualList = Filer.ReadFileLines("src/Tests/testReadFileLines.txt");

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void test_GetRandomString() {
    	ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("random line");

        String randomString = Filer.getRandomString("src/Tests/testGetRandomString.txt");
        Assert.assertEquals(expectedList.get(0), randomString);

    }
//    @Test
//    public void testGetRandomString_incorrectPath() {
//        //ArrayList<String> listStrings = new ArrayList<String>();
//
//        //listStrings.add("test/path/dont");
//        
//
//        String randomString = Filer.ReadFileLines("test/path/dont").get(0);
//        Assert.assertNull(randomString.toString());
//
//    }
}