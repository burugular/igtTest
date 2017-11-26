package com.example.rao.igttest.Games.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rao on 22/11/2017.
 */

public class GamesEntity {

    @SerializedName("response")
    private String response;
    @SerializedName("currency")
    private String currency;
    @SerializedName("data")
    private List<GameEntity> gameEntities;

    public String getResponse() {
        return response;
    }

    public String getCurrency() {
        return currency;
    }

    public List<GameEntity> getGameEntities() {
        return gameEntities;
    }
}
