package com.ohiocityburrito.mobile.activity;

import com.ohiocityburrito.mobile.activity.OCBBaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;

abstract class OCBActivityUnitTestCase<T extends OCBBaseActivity> extends ActivityUnitTestCase<T>{

    protected Helper helper;

    public OCBActivityUnitTestCase(Class<T> activityClass) {
        super(activityClass);
    }
    
    @Override
    public T startActivity(Intent intent, Bundle savedInstanceState, Object lastNonConfigurationInstance) {
        return super.startActivity(intent, savedInstanceState, lastNonConfigurationInstance);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        helper = new Helper(this);
        helper.setupActionBarSherlockThemedContext();
    }
    
    public void startActivityLifecycle() {
        helper.startActivity();
    }

}
