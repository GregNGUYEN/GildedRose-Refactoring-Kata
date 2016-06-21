package com.gildedrose.items;

import com.gildedrose.GildedRose;

public class SulfurasItem extends Item {
    public SulfurasItem(int sellIn, int quality) {
        super(GildedRose.SULFURAS, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        //DO Nothing
    }
}
