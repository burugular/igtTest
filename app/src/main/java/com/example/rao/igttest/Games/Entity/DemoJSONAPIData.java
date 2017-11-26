package com.example.rao.igttest.Games.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rao on 22/11/2017.
 */

public class DemoJSONAPIData {
    @SerializedName("userId")
    private String UserId;
    @SerializedName("id")
    private String Id;
    @SerializedName("title")
    private String Title;
    @SerializedName("body")
    private String Body;

    public String getUserId() {
        return UserId;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getBody() {
        return Body;
    }
}
