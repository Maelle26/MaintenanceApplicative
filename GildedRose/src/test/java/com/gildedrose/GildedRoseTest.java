package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    //Test qui vérifie que la qualité ne soit jamais négative
    @Test
    public void updateStandardItemQuality(){
        StockItems[] items = new StockItems[] {new NormalItems ("carotte", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //Test quand un produit standard à un sellin < 0 et que la qualité est supérieure à 0
    @Test
    public void updateStandardItemSellIn(){
        StockItems[] items = new StockItems[] {new NormalItems ("carotte", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    //Test que la qualité ne soit jamais supérieure à 50 (produits lambda)
    @Test
    public void updateStandardItemMaxQuality(){
        StockItems[] items = new StockItems[] {new NormalItems ("carotte", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);

    }

    //Aged Brie

    //Test que la qualité du "Aged Brie" augmente
    @Test
    public void updateAgedBrieQuality(){
        StockItems[] items = new StockItems[] {new AgedBrie ("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    //Test que la qualité di "Aged Brie" ne dépasse pas 50
    @Test
    public void updateAgedBrieMaxQuality(){
        StockItems[] items = new StockItems[] {new AgedBrie ("Aged Brie", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    //Teste quand le sellin est inférieur à 0
    @Test
    public void updateAgedBrieSellIn(){
        StockItems[] items = new StockItems[] {new AgedBrie ("Aged Brie", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    //Sulfuras

    //Test que la qualité de "Sulfuras" soit toujours à 80
    @Test
    public void updateAgedSulfurasQuality(){
        StockItems[] items = new StockItems[] {new Sulfuras ("Sulfuras, Hand of Ragnaros", 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    //Backstage passes

    //Test  La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la
    // qualité tombe à 0 après le concert.
    @Test
    public void updateAgedBackstagePassesQuality(){
        StockItems[] items = new StockItems[] {new BackstagePasses ("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    public void updateAgedBackstagePassesQuality2(){
        StockItems[] items = new StockItems[] {new BackstagePasses ("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    //Teste quand il ne rste plus de jours
    @Test
    public void updateAgedBackstagePassesQuality3(){
        StockItems[] items = new StockItems[] {new BackstagePasses ("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //Conjured

    //Test que la qualité de "Conjured" diminue 2 foiq plus vite que les autres produits
    @Test
    public void updateConjuredQuality(){
        StockItems[] items = new StockItems[] {new Conjured ("Conjured", 2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    //Teste quand le sellin est inférieur à 0
    @Test
    public void updateConjuredSellIn(){
        StockItems[] items = new StockItems[] {new Conjured ("Conjured", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }



}
