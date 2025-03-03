package com.gildedrose;

public class Conjured extends StockItems {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality > 0) {
            quality = quality - 2;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 2;
            }
        }
    }
}
