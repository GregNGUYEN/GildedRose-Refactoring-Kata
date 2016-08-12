package com.gildedrose.items;


import com.gildedrose.GildedRose;

public class BackstageItem extends Item {
    public BackstageItem(int sellIn, int quality) {

        super(GildedRose.BACKSTAGE, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (hasNotMaxQuality()) {
            increaseQuality();
            increaseQualityTwiceIfLessThan2WeeksAndThriceIfLessThanOneWeek();
        }
        deceaseSellIn();
        if (isExpired()) {
            quality = 0;
        }
    }

    void increaseQualityTwiceIfLessThan2WeeksAndThriceIfLessThanOneWeek() {
        if (isLessThan11DaysLeft()) {
            increaseQualityIfPossible();
            if (isLessThan6DaysLeft()) {
                increaseQualityIfPossible();
            }
        }


    }

    private boolean isLessThan6DaysLeft() {
        return sellIn < 6;
    }

    private boolean isLessThan11DaysLeft() {
        return sellIn < 11;
    }


}
