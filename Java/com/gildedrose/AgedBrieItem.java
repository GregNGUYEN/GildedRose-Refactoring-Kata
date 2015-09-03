package com.gildedrose;

/**
 * Created by gnguyen on 03/09/2015.
 */
public class AgedBrieItem extends AbstratcItem {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
            GildedRose.updateQualityForAgedBrie(this);
    }
}
