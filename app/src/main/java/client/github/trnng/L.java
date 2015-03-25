package client.github.trnng;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by alexey.bukin on 25.03.2015.
 */
public class L {
    public static void m(String message) {
        Log.d("TRNNG", message);
    }

    public static void s(Context context, String message) {

        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
