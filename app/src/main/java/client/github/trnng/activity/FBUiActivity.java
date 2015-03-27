package client.github.trnng.activity;

import android.app.Activity;
import android.os.Bundle;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 27.03.2015.
 */
public class FBUiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_ui);
        setTitle("FB ui example");
    }
}
