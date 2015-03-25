package client.github.trnng.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class ButtonTrnngActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(new ButtonHandler());
        btn3.setOnClickListener(o);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "button4 was clicked");
            }
        });


    }

    public void Something (View v)
    {
        Log.d("Button", "button1 was clicked");
    }

    @Override
    public void onClick(View v) {

    }

    class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Log.d("Button", "button2 was clicked");
        }
    }

    View.OnClickListener o = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Button", "button3 was clicked");
        }
    };
}
