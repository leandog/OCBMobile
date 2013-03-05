package com.ohiocityburrito.mobile.activity;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.ohiocityburrito.mobile.OCBApplication;
import com.ohiocityburrito.mobile.R;
import com.ohiocityburrito.mobile.R.id;
import com.ohiocityburrito.mobile.menu.MenuContentAdapter;
import com.ohiocityburrito.mobile.menu.MenuContentItem;
import com.ohiocityburrito.mobile.menu.MenuSource;

public class MenuActivity extends OCBBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setupCallAndDirectionsButtons();
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        ListView menuListView = (ListView) findViewById(id.menu_list_view);
        menuListView.setAdapter(new MenuContentAdapter(this, getItems()));
    }

    private List<MenuContentItem> getItems() {
        OCBApplication application = (OCBApplication) getApplication();
        MenuSource menuSource = application.getMenuSource();
        return menuSource.getMenuContentItems();
    }
}
