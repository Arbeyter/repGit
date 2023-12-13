package main.Inventory;
import main.Items.Items.Impl.ItemImpl;

import java.util.ArrayList;
public class Inventory {
    int size;
    int currentSize;
    ArrayList<ItemImpl> inventory;
    Inventory(int size){
        this.size = size;
    }
    public boolean addItem(ItemImpl thing){
        if (currentSize <= size){
            inventory.add(thing);
            return true;
        }
        else {
            return false;
        }
    }
    private int searchItem(long id){
        for (int i= 0;i<currentSize;i++){
            if (inventory.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public boolean delItem(long id){
        if (searchItem(id) != -1){
            inventory.removeIf(t -> t.getId() == id);
            return true;
        }
        return false;
    }
    public int getSize() {
        return size;
    }
}
