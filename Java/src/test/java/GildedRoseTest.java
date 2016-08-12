import com.gildedrose.GildedRose;
import com.gildedrose.items.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_decreases_in_Quality() throws Exception {
        Item sulfuras = new SulfurasItem(0, 80);
        Item[] items = {sulfuras};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(80, sulfuras.quality);


    }
    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_sold() throws Exception {
        Item sulfuras = new SulfurasItem(0, 80);
        Item[] items = {sulfuras};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(0, sulfuras.sellIn);

    }



    @Test
    public void at_the_end_of_each_day_our_system_lowers_sell_in_for_every_item() throws Exception {
        Item normalItem = new NormalItem("+5 Dexterity Vest", 10, 20);
        Item[] items = {normalItem};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();


        assertEquals(9, normalItem.sellIn);
    }

    @Test
    public void at_the_end_of_each_day_our_system_lowers_quality_for_every_item() throws Exception {
        Item normalItem = new NormalItem("+5 Dexterity Vest", 10, 20);
        Item[] items = {normalItem};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(19, normalItem.quality);
    }

    @Test
    public void the_Quality_of_an_item_is_never_negative() throws Exception {
        Item normalItem = new NormalItem("+5 Dexterity Vest", 10, 0);
        Item[] items = {normalItem};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(0, normalItem.quality);
    }

    @Test
    public void once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast() throws Exception {
        Item normalItem = new NormalItem("+5 Dexterity Vest", -1, 25);
        Item[] items = {normalItem};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();


        assertEquals(23, normalItem.quality);
    }


    @Test
    public void aged_Brie_actually_increases_in_Quality_the_older_it_gets() throws Exception {
        Item agedBrie = new AgedBrieItem(10, 25);
        Item[] items = {agedBrie};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();


        assertEquals(26, agedBrie.quality);
    }


    @Test
    public void the_Quality_of_an_item_is_never_more_than_50() throws Exception {
        Item agedBrie = new AgedBrieItem(10, 50);
        Item backStagePassMoreThan10DaysAway = new BackstageItem(15, 50);
        Item backStagePass10DaysAway = new BackstageItem(5, 49);
        Item backStagePass5DaysAway = new BackstageItem(5, 48);

        Item[] items = {agedBrie, backStagePass5DaysAway, backStagePass10DaysAway, backStagePassMoreThan10DaysAway};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();


        assertEquals(50, backStagePassMoreThan10DaysAway.quality);
        assertEquals(50, backStagePass10DaysAway.quality);
        assertEquals(50, backStagePass5DaysAway.quality);

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void backstage_passes_Quality_drops_to_0_after_the_concert() throws Exception {
        Item backStagePass = new BackstageItem(-1, 20);
        Item[] items = {backStagePass};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(0, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_1_when_the_concert_is_more_than_10_days_away() throws Exception {
        Item backStagePass = new BackstageItem(11, 20);
        Item[] items = {backStagePass};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(21, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_2_when_the_concert_is_10_days_or_less_away() throws Exception {
        Item backStagePass = new BackstageItem(10, 27);
        Item[] items = {backStagePass};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        assertEquals(29, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_3_when_the_concert_is_5_days_or_less_away() throws Exception {
        Item backStagePass = new BackstageItem(5, 44);
        Item[] items = {backStagePass};
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();


        assertEquals(47, backStagePass.quality);
    }



}
