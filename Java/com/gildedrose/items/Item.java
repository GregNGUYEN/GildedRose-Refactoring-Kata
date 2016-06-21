package com.gildedrose.items;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public abstract void updateQuality();

    protected boolean hasQuality() {
        return quality > 0;
    }

    protected void increaseQuality() {
        quality = quality + 1;
    }

    protected void decreaseQuality() {
        quality = quality - 1;
    }

    protected boolean isExpired() {
        return sellIn < 0;
    }

    protected void deceaseSellIn() {
        sellIn = sellIn - 1;
    }

    protected boolean hasNotMaxQuality() {
        return quality < 50;
    }

    protected void increaseQualityIfPossible() {
        if (hasNotMaxQuality()) {
            increaseQuality();
        }
    }
}
