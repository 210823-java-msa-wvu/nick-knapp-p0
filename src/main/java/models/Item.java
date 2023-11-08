package models;

public class Item {
    String itemName;
    String itemSpecs;
    int itemID;
    int numInStock;
    //BigDecimal double price;


    public Item(String itemName, String itemSpecs, int numInStock) {
        this.itemName = itemName;
        this.itemSpecs = itemSpecs;
        this.numInStock = numInStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecs() {
        return itemSpecs;
    }

    public void setItemSpecs(String itemSpecs) {
        this.itemSpecs = itemSpecs;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }
}
