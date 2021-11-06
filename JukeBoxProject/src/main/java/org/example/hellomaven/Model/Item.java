package org.example.hellomaven.Model;

import java.time.LocalTime;

public class Item {
    String itemName;
    LocalTime itemDuration;
    String itemType;
    int itemID;
    public Item(String itemType,int itemID,String itemName,LocalTime itemDuration)
    {
        this.itemID=itemID;
        this.itemType=itemType;
        this.itemName=itemName;
        this.itemDuration=itemDuration;
    }
    public String toString()
    {
        return String.format("%10s %10d %20s %20s",itemType,itemID,itemName,itemDuration);
    }

}
