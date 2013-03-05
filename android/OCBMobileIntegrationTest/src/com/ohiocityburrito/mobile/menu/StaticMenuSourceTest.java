package com.ohiocityburrito.mobile.menu;

import java.io.InputStream;
import java.util.List;

import com.ohiocityburrito.mobile.OCBApplication;
import com.ohiocityburrito.mobile.R;
import com.ohiocityburrito.mobile.menu.LocallyStoredMenuSource;
import com.ohiocityburrito.mobile.menu.MenuContentItem;
import com.ohiocityburrito.mobile.menu.MenuSource;

import android.test.ApplicationTestCase;

public class StaticMenuSourceTest extends ApplicationTestCase<OCBApplication>{
    
    public StaticMenuSourceTest() {
        super(OCBApplication.class);
    }

    public void testThatItReturnsAListOfMenuContentItemsFromDisk() {
        createApplication();
        
        List<MenuContentItem> items = getMenuItemsStoredLocally();
        
        assertNotNull(items);
        assertTrue(items.size() > 0);
    }
    
    public void testThatHeadersAreReturned() {
        createApplication();
        
        List<MenuContentItem> items = getMenuItemsStoredLocally();
        
        assertTrue("The header 'Burritos' wasn't found",items.contains(new MenuContentItem("Burritos")));
        assertTrue("The header 'Tacos' wasn't found",items.contains(new MenuContentItem("Tacos")));
    }
    
    public void testThatItemsAreReturned() {
        createApplication();
        
        List<MenuContentItem> items = getMenuItemsStoredLocally();
 
        assertTrue("Veggie Burrito wasn't found",items.contains(new MenuContentItem("Veggie Burrito","Just the same as Brother's, no meat","$5.85")));
        assertTrue("Baby Burrito wasn't found",items.contains(new MenuContentItem("Baby Burrito","Soft taco shell rolled up with beans, cheese & salsa","$1.85")));
    }
    
    private List<MenuContentItem> getMenuItemsStoredLocally() {
        MenuSource menuSource = new LocallyStoredMenuSource(getMenuInputStream());
        List<MenuContentItem> items = menuSource.getMenuContentItems();
        return items;
    }

    private InputStream getMenuInputStream() {
        return getApplication().getResources().openRawResource(R.raw.menu);
    }
    
    
}
