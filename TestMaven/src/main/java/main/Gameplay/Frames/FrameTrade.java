package main.Gameplay.Frames;

import java.util.ArrayList;
import java.util.Random;

import main.Gameplay.TypeFrame;
import main.Items.Items.Impl.ItemImpl;
public class FrameTrade extends Frame {
    Random random = new Random();
    ArrayList<ItemImpl> items = new ArrayList<ItemImpl>();
    public FrameTrade(String name, TypeFrame typeAct){
        super(name, String.format("%s", "Вы находите шмотки:\n"));
        typeAct = TypeFrame.TRADE;
        for (int i=0; i< random.nextInt(1,5);i++){
            items.add(new ItemImpl());
        }
    }
    @Override
    public String getText() {
        return "test";//super.getText() + "\n"+"Здоровье "+enemy.getName()+": "+ enemy.getHealth();
    }
}
