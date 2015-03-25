package client.github.trnng.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class saveStateActivity extends Activity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savestate);
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d("SaveInstanceState", "counter saved :" + counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("SaveInstanceState", "counter restored :" + counter);

    }
}
