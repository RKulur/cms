package org.cms.cateringmanagementsystem;

import javafx.scene.control.CheckBox;

public class Item {
  private String itemCategory;
   private CheckBox itemCheckbox;
   private String itemName;
   private double itemPrice;

    public Item(String itemCategory, CheckBox itemCheckbox, String itemName, double itemPrice) {
        this.itemCategory = itemCategory;
        this.itemCheckbox = itemCheckbox;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }
    public boolean isItemSelected() {
        return this.itemCheckbox.isSelected();
    }

    public String getItemCategory() {
        return itemCategory;
    }
}
