package com.gildedrose.items;

public class NormalItem extends Item{
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (hasQuality()) {
            decreaseQuality();
        }
        deceaseSellIn();
        if (isExpired()) {
            if (hasQuality()) {
                decreaseQuality();
            }
        }
    }
}
