package client.github.trnng.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 27.03.2015.
 */
public class UiTrnngActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_trnng);
    }

    public void openActivity(View v){

        if (v.getId()==R.id.btn_calculate_activity){
            Intent intent = new Intent(this, CalculateActivity.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.btn_fb_trainig_activity){
            Intent intent = new Intent(this, FBUiActivity.class);
            startActivity(intent);
        }
    }
}
