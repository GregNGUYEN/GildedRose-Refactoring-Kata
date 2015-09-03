package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    AbstratcItem[] items;

    public GildedRose(AbstratcItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (AbstratcItem item : items) {
            item.updateQuality();

        }
    }

    public static void updateQualityforNormalItems(AbstratcItem item) {
        if (item.hasQuality()) {
            item.decreaseQuality();
        }
        item.decraseSellIn();
        if (item.isExpired()) {
            if (item.hasQuality()) {
                item.decreaseQuality();
            }
        }
    }

    public static void updateQualityforBackstage(AbstratcItem item) {
        if (item.hasNotMaxQuality()) {
            item.increaseQuality();
            upadate_for_backstage(item);
        }
        item.decraseSellIn();
        if (item.isExpired()) {
            item.quality = 0;
        }
    }

    public static void updateQualityForAgedBrie(AbstratcItem item) {
        if (item.hasNotMaxQuality()) {
            item.increaseQuality();
        }
        item.decraseSellIn();
        if (item.isExpired()) {
            if (item.hasNotMaxQuality()) {
                item.increaseQuality();
            }
        }
    }

    private static void upadate_for_backstage(AbstratcItem item) {
        if (item.sellIn < 11) {
            if (item.hasNotMaxQuality()) {
                item.increaseQuality();
            }
        }

        if (item.sellIn < 6) {
            if (item.hasNotMaxQuality()) {
                item.increaseQuality();
            }
        }
    }
}
