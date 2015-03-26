package client.github.trnng.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class LaunchActivity extends Activity implements View.OnClickListener{

    Button flowerAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        flowerAct = (Button) findViewById(R.id.btn_flwr_activity);
        flowerAct.setOnClickListener(this);
    }

    public void openActivity (View v){
        if (v.getId() == R.id.btn_flwr_activity)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_btn_activity)
        {
            Intent intent = new Intent(this, ButtonTrnngActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_intent_activity)
        {
            Intent intent = new Intent(this, IntentTrnngActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_savedInstanceState_activity)
        {
            Intent intent = new Intent(this, saveStateActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_toast_activity)
        {
            Intent intent = new Intent(this, ToastActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_calculate_activity)
        {
            Intent intent = new Intent(this, CalculateActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
