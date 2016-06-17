package com.gildedrose;

/**
 * Created by gnguyen on 03/09/2015.
 */
public abstract class AbstratcItem {
    public String name;
    public int sellIn;
    public int quality;

    public AbstratcItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract void updateQuality();

    boolean hasQuality() {
        return quality > 0;
    }

    void decreaseQuality() {
        quality = quality - 1;
    }

    boolean isExpired() {
        return sellIn < 0;
    }

    void decraseSellIn() {
        sellIn = sellIn - 1;
    }

    void increaseQuality() {
        quality = quality + 1;
    }

    boolean hasNotMaxQuality() {
        return quality < 50;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
