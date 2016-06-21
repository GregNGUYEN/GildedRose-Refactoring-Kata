package com.gildedrose.items;

public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
