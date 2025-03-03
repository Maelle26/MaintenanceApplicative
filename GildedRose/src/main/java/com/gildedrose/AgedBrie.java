package com.gildedrose;

public class AgedBrie extends NormalItems{

    //constructeur
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    //méthode pour mettre à jour la qualité
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
