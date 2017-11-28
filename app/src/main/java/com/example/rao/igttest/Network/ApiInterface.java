package com.example.rao.igttest.Network;

import com.example.rao.igttest.Games.Entity.DemoJSONAPIData;
import com.example.rao.igttest.Games.Entity.GamesEntity;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Rao on 22/11/2017.
 */

public interface ApiInterface {
    @GET("gameData")
    Observable<GamesEntity> getGamesData();

    @GET("/posts")
    Single<DemoJSONAPIData> getDemoData();
}
