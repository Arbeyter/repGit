package main.Gameplay.Frames;
import main.Entity.Entity;
import main.Gameplay.TypeFrame;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
abstract public class Frame {
    String name;
    List<Frame> variants;
    String description;
    TypeFrame typeAct;
    public Frame(String name, String description){
        this.name = name;
        variants = new ArrayList<Frame>();
        this.description = description;
    }
    public void setVariants(List<Frame> vars){
        variants = vars;
    }
    public void setVariants(Frame... frames){
        variants.addAll(Arrays.asList(frames));
//        for(Frame frame : frames){
//            variants.add(frame);
//        }
    }
    public List<Frame> getVariants(){
        return variants;
    }
    public String getDescription(){
        return description;
    }
    public TypeFrame getTypeAct(){
        return typeAct;
    }
    public String getText(){
        return getTypeAct() + "\n" + getName() + '\n' + getDescription();
    }
    public String getName(){return name;}
    public boolean getStatus(){
        return true;
    }

    public Entity getEnemy() {
        return new Entity("lol", 228);
    }
}
