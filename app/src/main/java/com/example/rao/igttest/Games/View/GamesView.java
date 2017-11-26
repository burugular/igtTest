package com.example.rao.igttest.Games.View;

import com.example.rao.igttest.Games.Entity.GameEntity;

import java.util.List;

/**
 * Created by Rao on 21/11/2017.
 */

public interface GamesView {

    /**
     * Initialise the recycler view to list Games data
     * @param gameEntities
     */
    void initRecyclerView(List<GameEntity> gameEntities);

    void showToast(String message);

    void onListItemClick(GameEntity gameEntity);
}
