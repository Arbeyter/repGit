package main.Entity;
import main.Inventory.Inventory;

public class Entity {
    String name;
    int maxHealth;
    int health;
    Inventory inventory;
    public Entity(String name, int maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        health = maxHealth;
    }
    public Entity() {
    	this.name = "test";
    	this.maxHealth = 20;
    	health = maxHealth;
    }
    public void editHealth(int var){
        health += var;
    }
    public int getHealth(){
        return health;
    }
    public String getName(){return name;}
}
