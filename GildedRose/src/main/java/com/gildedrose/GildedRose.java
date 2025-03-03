package com.gildedrose;

class GildedRose {

    //atributs
    StockItems[] items;

    //constructeur
    public GildedRose(StockItems[] items) {
        this.items = items;
    }

    //Version plus optimale avec l'utilisation des objets
    public void updateQuality() {
        for (StockItems i : items) {
            i.updateQuality();
        }
    }

}
