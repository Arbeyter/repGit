package main.Gameplay.Manager.Battle;

public enum FightVariants {
    ATTACK ("атака"),
    HEAL ("лечение"),
    LEAVE ("сбежать"),
	BLOCK ("Блокировать");
    FightVariants(String act){
        this.act = act;
    }
    public String getAct() {
        return act;
    }
    private String act;
}
