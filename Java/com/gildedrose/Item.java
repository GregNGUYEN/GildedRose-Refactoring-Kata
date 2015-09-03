package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQualityforBackstage() {
        if (hasNotMaxQuality()) {
            increaseQuality();
            upadate_for_backstage();
        }
        decraseSellIn();
        if (isExpired()) {
            quality = 0;
        }
    }

    void upadate_for_backstage() {
        if (sellIn < 11) {
            if (hasNotMaxQuality()) {
                increaseQuality();
            }
        }

        if (sellIn < 6) {
            if (hasNotMaxQuality()) {
                increaseQuality();
            }
        }
    }

    public void updateQualityForAgedBrie() {
        if (hasNotMaxQuality()) {
            increaseQuality();
        }
        decraseSellIn();
        if (isExpired()) {
            if (hasNotMaxQuality()) {
                increaseQuality();
            }
        }
    }

    public void updateQualityforNormalItems() {
        if (hasQuality()) {
            decreaseQuality();
        }
        decraseSellIn();
        if (isExpired()) {
            if (hasQuality()) {
                decreaseQuality();
            }
        }
    }

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


    void updateQuality() {
        if (name.equals(GildedRose.AGED_BRIE)) {
            this.updateQualityForAgedBrie();
        } else if (name.equals(GildedRose.BACKSTAGE)) {
            this.updateQualityforBackstage();
        } else if (!name.equals(GildedRose.SULFURAS)) {
            this.updateQualityforNormalItems();
        }
    }

}
