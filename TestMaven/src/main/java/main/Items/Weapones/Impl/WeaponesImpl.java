package main.Items.Weapones.Impl;

import main.Items.ItemTypes;
import main.Items.Items.Impl.ItemImpl;

public class WeaponesImpl extends ItemImpl {
    static String nameFile = "name_weapone.txt";
    ItemTypes itemType = ItemTypes.WEAPONES;
    public WeaponesImpl(){
        setId();
        buildAdjective();
        buildName();
        buildCharacteristic();
    }
}
