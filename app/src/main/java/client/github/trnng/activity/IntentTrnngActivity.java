package client.github.trnng.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import client.github.trnng.R;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class IntentTrnngActivity extends Activity{

//    Button btnMap = (Button) findViewById(R.id.btn_map_launch);
//    Button btnGooglePlay = (Button) findViewById(R.id.btn_store_launch);
//    Button btnEmailClient = (Button) findViewById(R.id.btn_email_launch);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_intent);
    }

    public void intentLaunch(View v)
    {
        Intent intent = null, chooser = null;

        if (v.getId()==R.id.btn_map_launch)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo: 59.570 , 30.190"));
            chooser=Intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);
        }

        if (v.getId()==R.id.btn_store_launch)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=tutorial.DrawSample"));
            chooser=Intent.createChooser(intent,"Launch Market");
            startActivity(chooser);
        }

        if (v.getId()==R.id.btn_email_launch)
        {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String [] to = {"alexeybookin@gmail.com","mfkr@mail.ru"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test email from trnng app");
            intent.putExtra(Intent.EXTRA_TEXT, "this is test email message");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Launch Email Client");
            startActivity(chooser);
        }
    }
}
