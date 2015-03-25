package client.github.trnng.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class ToastActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

    }

    public void showToast(View v)
    {
        Toast toast = Toast.makeText(this, "This is toast", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void showCustomToast(View v)
    {
        Toast customToast = new Toast(this);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.setGravity(Gravity.BOTTOM,0,0);

        LayoutInflater lin = getLayoutInflater();
        View appear = lin.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_linear_layout));
        customToast.setView(appear);
        customToast.show();

    }
}
