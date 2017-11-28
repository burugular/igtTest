package com.example.rao.igttest.Games.Presenter;

import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.View.GamesView;

/**
 * Created by Rao on 22/11/2017.
 */

public interface GamesPresenter {
    void setView(GamesView gamesView);
    void initUi();
    void showGameDetail(GameEntity gameEntity);

}
