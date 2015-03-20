package client.github.trnng;

import java.util.List;

import client.github.trnng.model.Flower;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by alexey.bukin on 20.03.2015.
 */
public interface FlowersAPI {

    @GET("/feeds/flowers.json")
    public void getFeed(Callback<List<Flower>> response);
}
