package main.Items.Items.Impl;

import main.Files.Filer;
import main.Items.NameTaker;

import main.Items.ItemTypes;
import main.Items.Items.Item;

public class ItemImpl implements Item {
    static String pathToFiles = "src/rsc/";
    static String adjFile = "adjective.txt";
    static String nameFile = "name_items.txt";
    String adjective;
    public String name;
    static long lastId=1;
    long id;
    ItemTypes itemType = ItemTypes.ITEMS;
    //@Override

    public ItemImpl(){
        setId();
        buildAdjective();
        buildName();
        buildCharacteristic();
    }
    public void setId(){
        id = lastId;
        lastId++;
    }
    public long getId(){
        return id;
    }
    public void buildAdjective(){
        adjective = Filer.getRandomString(pathToFiles + adjFile);
    };
    public void buildName(){
        name = NameTaker.buildName(itemType);
    }
    public void buildCharacteristic(){};
    public String getInfo(){
        return Long.toString(id) + ' ' + adjective + ' '+ name;
    }
    public String getAdjective() {
    	return adjective;
    }
}
