package com.ohiocityburrito.mobile.activity;

import static com.ohiocityburrito.mobile.Utils.Displays.getDisplayMetrics;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.ohiocityburrito.mobile.R;
import com.ohiocityburrito.mobile.Utils.Displays;


public class MainActivity extends OCBBaseActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sizeMainSkellyImage();
        setupCallAndDirectionsButtons();
        setupMenuNavigation();
    }
    
    private void setupMenuNavigation() {
        findViewById(R.id.menu_view).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                launcher.navigateToMenu();
            }
        });
    }
    
    private void sizeMainSkellyImage() {
        if(getDisplayMetrics(this).widthPixels <= Displays.NORMAL_WIDTH_IN_PX) {
            ImageView skellyView = (ImageView) findViewById(R.id.skelly_image_view);
            skellyView.setImageResource(R.drawable.skelly_small);
        }
    }
}
