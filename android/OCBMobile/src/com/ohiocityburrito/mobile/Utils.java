package com.ohiocityburrito.mobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

public class Utils {

    public static class Json {
        public static JSONObject jsonFromInputStream(InputStream inputStream) {
            try {
                StringBuilder fileText = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    fileText.append(line);
                    fileText.append("\n");
                }
                return new JSONObject(fileText.toString());
            } catch (Exception e) {
                Log.e("ocb", "failure at jsonFromInputStream", e);
                return new JSONObject();
            }
        }
    }

    public static class Strings {
        public static boolean isNullOrEmpty(String string) {
            return string == null || string.trim().isEmpty();
        }
    }
    
    public static class Displays {
        public static DisplayMetrics getDisplayMetrics(Activity activity) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getMetrics(outMetrics);
            return outMetrics;
        }

        public static final int NORMAL_WIDTH_IN_PX = 480;
    }

}
