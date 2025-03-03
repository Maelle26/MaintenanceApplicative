package com.gildedrose;

public class Sulfuras extends StockItems {

    public Sulfuras(String name, int sellIn) {
        super(name, sellIn, 80);
    }

    @Override
    public void updateQuality() {
        // Sulfuras n'a pas de date de péremption et sa qualité ne change jamais
    }
}
