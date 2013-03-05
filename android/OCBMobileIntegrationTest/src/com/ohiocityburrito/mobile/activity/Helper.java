package com.ohiocityburrito.mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.ohiocityburrito.mobile.activity.OCBBaseActivity;

class Helper {
    
    final OCBActivityUnitTestCase<? extends OCBBaseActivity> test;

    public Helper(OCBActivityUnitTestCase<? extends OCBBaseActivity> test) {
        this.test = test;
    }

    public Intent intentForSelectingMenuText(String text) {
        OCBBaseActivity activity = test.getActivity();
        MenuBuilder builder = new MenuBuilder(activity);
        activity.onMenuItemSelected(0, builder.add(text));
        return test.getStartedActivityIntent();
    }

    OCBBaseActivity startActivity() {
        return test.startActivity(new Intent(), new Bundle(), null);
    }

    void setupActionBarSherlockThemedContext() {
        Context instrumentationContext = test.getInstrumentation().getTargetContext();
        int themeId = com.actionbarsherlock.R.style.Theme_Sherlock_Light_DarkActionBar;
        ContextThemeWrapper context = new ContextThemeWrapper(instrumentationContext, themeId);
        test.setActivityContext(context);
    }

    Intent intentForClicking(int viewId) {
        View view = test.getActivity().findViewById(viewId);
        view.performClick();
        return test.getStartedActivityIntent();
    }
}