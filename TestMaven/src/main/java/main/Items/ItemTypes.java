package main.Items;

public enum ItemTypes {
    ITEMS ("name_items.txt"),
    CLOTHES ("name_clothes.txt"),
    WEAPONES ("name_weapone.txt");

    ItemTypes(String path){
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    private String path;
    @Override
    public String toString(){
        return path;
    }
}
