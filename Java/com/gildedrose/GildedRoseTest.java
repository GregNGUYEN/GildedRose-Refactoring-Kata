package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class GildedRoseTest {

    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_decreases_in_Quality() throws Exception {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());

        sut.updateQuality();

        assertEquals(80, sulfuras.quality);


    }
    @Test
    public void Sulfuras_being_a_legendary_item_never_has_to_be_sold() throws Exception {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(sulfuras).toArray());

        sut.updateQuality();

        assertEquals(0, sulfuras.sellIn);


    }



    @Test
    public void at_the_end_of_each_day_our_system_lowers_sell_in_for_every_item() throws Exception {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();


        assertEquals(9, normalItem.sellIn);
    }

    @Test
    public void at_the_end_of_each_day_our_system_lowers_quality_for_every_item() throws Exception {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();


        assertEquals(19, normalItem.quality);
    }

    @Test
    public void the_Quality_of_an_item_is_never_negative() throws Exception {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 0);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();


        assertEquals(0, normalItem.quality);
    }

    @Test
    public void once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast() throws Exception {
        Item normalItem = new Item("+5 Dexterity Vest", -1, 25);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();


        assertEquals(23, normalItem.quality);
    }


    @Test
    public void aged_Brie_actually_increases_in_Quality_the_older_it_gets() throws Exception {
        Item agedBrie = new Item("Aged Brie", 10, 25);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(agedBrie).toArray());

        sut.updateQuality();


        assertEquals(26, agedBrie.quality);
    }


    @Test
    public void the_Quality_of_an_item_is_never_more_than_50() throws Exception {
        Item agedBrie = new Item("Aged Brie", 10, 50);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(agedBrie).toArray());

        sut.updateQuality();
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);

        Item backStagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item backStagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose sut2 = new GildedRose((Item[]) Arrays.asList(backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway).toArray());

        sut2.updateQuality();


        assertEquals(50, backStagePassMoreThan10DaysAway.quality);
        assertEquals(50, backStagePass10DaysAway.quality);
        assertEquals(50, backStagePass5DaysAway.quality);

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void backstage_passes_Quality_drops_to_0_after_the_concert() throws Exception {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();


        assertEquals(0, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_1_when_the_concert_is_more_than_10_days_away() throws Exception {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();


        assertEquals(21, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_2_when_the_concert_is_10_days_or_less_away() throws Exception {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();


        assertEquals(29, backStagePass.quality);
    }

    @Test
    public void backstage_passes_Quality_increases_quality_by_3_when_the_concert_is_5_days_or_less_away() throws Exception {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44);

        GildedRose sut = new GildedRose((Item[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();


        assertEquals(47, backStagePass.quality);
    }



}
