package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //Version plus optimale avec un switch
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Aged Brie":
                    handleAgedBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleBackstagePasses(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    handleSulfuras(items[i]);
                    break;
                case "Conjured":
                    handleConjured(items[i]);
                    break;
                default:
                    handleNormalItem(items[i]);
                    break;
            }
        }
    }

    //Gère le cas des produits normaux
    public void handleNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    //Gère le cas de l'item "Aged Brie"
    public  void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    //Gère le cas du produit "Sulfuras"
    public void handleSulfuras(Item item) {
        //Ne fait rien
    }

    //Gère le cas du produit "Backstage passes"
    public void handleBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    //Gère le casdes produit "Conjured"
    public void handleConjured(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2;
            }
        }
    }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }

}
