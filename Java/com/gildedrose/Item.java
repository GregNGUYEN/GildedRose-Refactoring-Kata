package com.gildedrose;

public class Item extends AbstratcItem {

    public Item(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        if (name.equals(GildedRose.AGED_BRIE)) {
            GildedRose.updateQualityForAgedBrie(this);
        } else if (name.equals(GildedRose.BACKSTAGE)) {
            GildedRose.updateQualityforBackstage(this);
        } else if (!name.equals(GildedRose.SULFURAS)) {
            GildedRose.updateQualityforNormalItems(this);
        }
    }

}
