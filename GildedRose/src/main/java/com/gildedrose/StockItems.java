package com.gildedrose;

public abstract class StockItems extends Item {

    public StockItems(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();
}
