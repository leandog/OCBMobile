package com.ohiocityburrito.mobile.activity;
import static com.ohiocityburrito.mobile.R.id.call_button;
import static com.ohiocityburrito.mobile.R.id.directions_button;
import android.content.Intent;

import com.ohiocityburrito.mobile.R.id;
import com.ohiocityburrito.mobile.activity.MainActivity;
import com.ohiocityburrito.mobile.activity.MenuActivity;

public class MainActivityTest extends OCBActivityUnitTestCase <MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testThatItCallsOhioCityBurrito() {
         startActivityLifecycle();

        Intent intent = helper.intentForClicking(call_button);

        assertEquals("tel:216-664-0908", intent.getDataString());
        assertEquals(Intent.ACTION_DIAL, intent.getAction());
    }

    public void testThatItGivesUsDirectionsToOhioCityBurrito() {
        startActivityLifecycle();
        
        Intent intent = helper.intentForClicking(directions_button);
        
        assertEquals("geo:0,0?q=Ohio+City+Burrito+1844+W+25th+St+Cleveland,+OH+44113", intent.getDataString());
    }
    
    public void testThatICanFollowOhioCityBurritoOnTwitter() {
        startActivityLifecycle();
        
        Intent intent = helper.intentForSelectingMenuText("Follow Us!");
        
        assertEquals("https://twitter.com/ocburrito", intent.getDataString());
        assertEquals(Intent.ACTION_VIEW, intent.getAction());
    }
    
    public void testThatICanLikeOhioCityBurritoOnFacebook() {
        startActivityLifecycle();
        
        Intent intent = helper.intentForSelectingMenuText("Like Us!");
        
        String facebookWebUrl = "http://facebook.com/pages/Ohio-City-Burrito/141369891769";
        String facebookAppUrl = "fb://profile/141369891769";
        String dataString = intent.getDataString();
        
        assertTrue("The intent started did not match the web or facebook application urls",facebookAppUrl.equals(dataString) || facebookWebUrl.equals(dataString));
        assertEquals(Intent.ACTION_VIEW, intent.getAction());
    }
    
    public void testThatICanEmailOhioCityBurrito() {
        startActivityLifecycle();
        
        Intent intent = helper.intentForSelectingMenuText("Email Us!");
        
        assertEquals("mailto:info@ohiocityburrito.com", intent.getDataString());
        assertEquals(Intent.ACTION_SENDTO, intent.getAction());
    }
    
    public void testThatICanNavigateToTheMenu() {
        startActivityLifecycle();
        
        Intent intent = helper.intentForClicking(id.menu_view);
        
        assertEquals(MenuActivity.class.getName(), intent.getComponent().getClassName());
    }
}
