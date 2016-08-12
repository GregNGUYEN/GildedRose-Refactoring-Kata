package com.gildedrose.items;

import com.gildedrose.GildedRose;

public class AgedBrieItem extends Item {

    public AgedBrieItem( int sellIn, int quality) {

        super(GildedRose.AGED_BRIE, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfPossible();
        deceaseSellIn();
        if (isExpired()) {
            increaseQualityIfPossible();
        }
    }
}
