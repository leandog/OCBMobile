package com.ohiocityburrito.mobile;

import java.io.InputStream;

import com.ohiocityburrito.mobile.menu.LocallyStoredMenuSource;
import com.ohiocityburrito.mobile.menu.MenuSource;

import android.app.Application;

public class OCBApplication extends Application {
    
    public MenuSource getMenuSource() {
        InputStream menuJsonStream = getResources().openRawResource(R.raw.menu);
        return new LocallyStoredMenuSource(menuJsonStream);
    }
    
}
