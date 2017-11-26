package com.example.rao.igttest.Games.Entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Rao on 21/11/2017.
 */

public class GameEntity {
    private String name;
    private Integer jackpot;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJackpot() {
        return jackpot;
    }

    public void setJackpot(Integer jackpot) {
        this.jackpot = jackpot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
