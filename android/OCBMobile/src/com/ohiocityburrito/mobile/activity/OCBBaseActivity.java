package com.ohiocityburrito.mobile.activity;

import static com.ohiocityburrito.mobile.R.string.email_text;
import static com.ohiocityburrito.mobile.R.string.facebook_text;
import static com.ohiocityburrito.mobile.R.string.twitter_text;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.ohiocityburrito.mobile.Launcher;
import com.ohiocityburrito.mobile.R;

public class OCBBaseActivity extends SherlockActivity {
    
    protected Launcher launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        launcher = new Launcher(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void setupActionBar() {
        ActionBar bar = getSupportActionBar();
        if (bar == null)
            return;
        bar.setDisplayUseLogoEnabled(true);
        bar.setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (getString(twitter_text).equals(item.getTitle())) {
            launcher.launchTwitter();
        } else if (getString(facebook_text).equals(item.getTitle())) {
            launcher.launchFacebook();
        } else if(getString(email_text).equals(item.getTitle())) {
            launcher.launchEmail();
        }
    
        return super.onMenuItemSelected(featureId, item);
    }

    protected void setupCallAndDirectionsButtons() {
        findViewById(R.id.call_button).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                launcher.dialOhioCityBurrito();
            }
        });
        findViewById(R.id.directions_button).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                launcher.showDirectionsOnMap();
            }
        });
    }

}
