package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.ItemFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class GildedRoseStepDef {

    private String itemName;
    private int itemQuality;
    private int itemSellIn;

    private GildedRose gildedRose;

    @Given("^an item \"([^\"]*)\"$")
    public void an_item(String name) throws Throwable {
        itemName = name;
    }

    @Given("^the quality is (-?\\d+)")
    public void the_quality_is(int quality) throws Throwable {
        itemQuality = quality;
    }

    @Given("^the sell in is (-?\\d+)")
    public void the_sell_in_is(int sellIn) throws Throwable {
        itemSellIn = sellIn;
    }

    @Given("^an item \"([^\"]*)\" with quality (-?\\d+) and sell in (-?\\d+)$")
    public void an_item_with_quality_and_sell_in(String name,
                                                 int quality, int sellIn) throws Throwable {
        itemName = name;
        itemQuality = quality;
        itemSellIn = sellIn;
    }

    @When("^I update quality$")
    public void i_update_quality() throws Throwable {

        Item item = ItemFactory.create(itemName, itemSellIn, itemQuality);
        Item[] items = new Item[]{item};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }

    @Then("^the quality is updated to (-?\\d+)$")
    public void the_quality_is_updated_to(int expected) throws Throwable {
        assertEquals(expected, gildedRose.items[0].quality);
    }

    @Then("^the sell in is updated to (-?\\d+)$")
    public void the_sell_in_is_updated_to(int expected) throws Throwable {
        assertEquals(expected, gildedRose.items[0].sellIn);
    }

    @Then("^the quality becomes (-?\\d+) and sell in becomes (-?\\d+)$")
    public void the_quality_becomes_and_sell_in_becomes(
            int expectedQuality, int expectedSellIn) throws Throwable {
        assertEquals(expectedQuality, gildedRose.items[0].quality);
        assertEquals(expectedSellIn, gildedRose.items[0].sellIn);
    }
    @Then("^the item's name is \"([^\"]*)\"$")
    public void the_item_s_name_is(String name) throws Throwable {
        assertEquals(name, itemName);
        assertEquals(name, gildedRose.items[0].name);
    }


}
