package com.gildedrose.items;

import com.gildedrose.GildedRose;

public class ItemFactory {

    public static Item create(String typeName, int sellIn, int quality) {
        if (GildedRose.SULFURAS.equals(typeName)) {
            return new SulfurasItem(sellIn, quality);
        } else if (GildedRose.AGED_BRIE.equals(typeName)) {
            return new AgedBrieItem(sellIn, quality);
        } else if (GildedRose.BACKSTAGE.equals(typeName)) {
            return new BackstageItem(sellIn, quality);
        } else {
            return new NormalItem(typeName, sellIn, quality);
        }
    }

}
