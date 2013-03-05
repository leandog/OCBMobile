package com.ohiocityburrito.mobile.menu;

import junit.framework.TestCase;

public class MenuContentItemTest extends TestCase {
    
    public void testThatItemsWithNoDescriptionAndPriceAreHeaders() {
        assertTrue(new MenuContentItem("header").isHeader());
        assertFalse(new MenuContentItem("Yummy Taco","","$3.10").isHeader());
        assertFalse(new MenuContentItem("Yummy Taco","So delicious","").isHeader());
    }

}
