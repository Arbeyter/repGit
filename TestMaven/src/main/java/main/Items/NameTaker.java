package main.Items;

import main.Files.Filer;

public class NameTaker {
    String clothes;
    String weapones;
    String itemsFile;
    static String pathToFiles = "src/rsc/items/";
    static public String buildAdjective(String adjFile){
        String adjective = Filer.getRandomString(adjFile);
        return adjective;
    }
    static public String buildAdjective(){
        String adjFile = "adjective.txt";
        String adjective = Filer.getRandomString(adjFile);
        return adjective;
    }
    static public String buildName(ItemTypes itemType)
    {
        String name = Filer.getRandomString(pathToFiles + itemType.getPath());
        return name;
    }

}
