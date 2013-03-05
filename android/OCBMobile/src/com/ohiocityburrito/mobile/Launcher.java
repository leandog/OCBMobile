package com.ohiocityburrito.mobile;

import static com.ohiocityburrito.mobile.R.string.*;
import java.util.List;

import com.ohiocityburrito.mobile.activity.MenuActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

public class Launcher {

    private final Activity activity;

    public Launcher(Activity activity) {
        this.activity = activity;
    }

    public void launchEmail() {
        activity.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(activity.getString(email_intent_uri))));
    }

    public void launchTwitter() {
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(activity.getString(twitter_intent_uri))));
    }

    public void launchFacebook() {
        String intentString = activity.getString(facebook_app_intent_uri);
        String faceBookPageString = activity.getString(facebook_web_intent_uri);

        if (applicationCanRespondTo(intentString)) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intentString)));
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(faceBookPageString)));
        }
    }

    public void dialOhioCityBurrito() {
        activity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(activity.getString(call_intent_uri))));
    }

    public void showDirectionsOnMap() {
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(activity.getString(map_intent_uri))));
    }

    private boolean applicationCanRespondTo(String intentString) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(intentString));
        PackageManager pm = activity.getPackageManager();
        List<ResolveInfo> queryIntentActivities = pm.queryIntentActivities(intent, 0);
        return queryIntentActivities.size() > 0;
    }

    public void navigateToMenu() {
        activity.startActivity(new Intent(activity.getBaseContext(), MenuActivity.class));
    }

}
