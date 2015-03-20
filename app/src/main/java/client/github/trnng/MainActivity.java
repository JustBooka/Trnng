package client.github.trnng;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import client.github.trnng.model.Flower;
import client.github.trnng.parser.FlowerJSONParser;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by alexey.bukin on 18.03.2015.
 */
public class MainActivity extends ListActivity {


    ProgressBar pb;
//    List<MyTask> tasks;

    List<Flower> flowerList;
    public static final String PHOTOS_BASE_URL = "http://services.hanselandpetal.com/photos/";
    public static final String ENDPOINT = "http://services.hanselandpetal.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

//        tasks = new ArrayList<>();

        if (isOnline()) {
            requestData("http://services.hanselandpetal.com/secure/flowers.json");
        } else {
            Toast.makeText(this, "Network isn`t available", Toast.LENGTH_LONG).show();
        }
    }

    // just for run asynctask

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_do_task) {
            if (isOnline()) {
                requestData("https://services.handselandpetal.com/feed/flowers.json");
            } else {
                Toast.makeText(this, "Network isn`t available", Toast.LENGTH_LONG).show();
            }
        }
        return false;
    }

    private void requestData(String uri) {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();

        FlowersAPI api = adapter.create(FlowersAPI.class);
        api.getFeed(new Callback<List<Flower>>() {

            @Override
            public void success(List<Flower> arg0, Response arg1) {
                flowerList = arg0;
                updateDisplay();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }

    private void updateDisplay() {
      FlowerAdapter adapter = new FlowerAdapter(this, R.layout.item_flower, flowerList);
        setListAdapter(adapter);
    }

    //permission
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    //-->asyncTask

//    private class MyTask extends AsyncTask<RequestPackage, String, List<Flower>> {
//
//        @Override
//        protected void onPreExecute() {
//            if (tasks.size() == 0) {
//                pb.setVisibility(View.VISIBLE);
//            }
//            tasks.add(this);
//        }
//
//        @Override
//        protected List<Flower> doInBackground(RequestPackage... params) {
//
//            String content = HttpManager.getData(params[0], "feeduser", "feedpassword");
//            flowerList = FlowerJSONParser.parseFeed(content);
//
//            return flowerList;
//        }
//
//        @Override
//        protected void onPostExecute(List<Flower> result) {
//
//            tasks.remove(this);
//            if (tasks.size() == 0) {
//                pb.setVisibility(View.INVISIBLE);
//            }
//
//            if (result == null){
//                Toast.makeText(MainActivity.this, "Can`t connect to web service", Toast.LENGTH_LONG).show();
//                return;
//            }
////            flowerList = FlowerJSONParser.parseFeed(result);
//            updateDisplay();
//
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//        }
//    }


    //<--AsyncTaskEnd

    // --> add for retrofit
//    public void requestData(String uri){
//
//        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint(ENDPOINT)
//                .build();
//
//        RepositoriesAPI api = adapter.create(RepositoriesAPI.class);
//        api.getRepos(new Callback<List<Repo>>() {
//
//            @Override
//            public void success(List<Repo> repos, Response response) {
//                repoList = arg0;
//                updateDisplay();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//
//            }
//        });
//    }
// <--
}
