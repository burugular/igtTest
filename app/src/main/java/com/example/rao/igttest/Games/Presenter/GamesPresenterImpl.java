package com.example.rao.igttest.Games.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rao.igttest.ApiClient;
import com.example.rao.igttest.ApiInterface;
import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.Entity.GamesEntity;
import com.example.rao.igttest.Games.View.FGames;
import com.example.rao.igttest.Games.View.GamesAdapter;
import com.example.rao.igttest.Games.View.GamesView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Rao on 22/11/2017.
 */

public class GamesPresenterImpl implements GamesPresenter {

    GamesView gamesView;
    private ApiInterface apiInterface;
    /**
     * Collects all subscriptions to unsubscribe later
     */
    @NonNull
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public GamesPresenterImpl() {}

    public GamesPresenterImpl(GamesView gamesView) {
        this.gamesView = gamesView;
    }

    @Override
    public void initUi() {
        getGamesData();
    }

    @Override
    public void showGameDetail(GameEntity gameEntity) {
        //GamesView gamesView = new FGames();
        gamesView.onListItemClick(gameEntity);

    }

    public void getGamesData() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Observable<GamesEntity> gamesWebOrbEntityObservable = apiInterface.getGamesData();
        gamesWebOrbEntityObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<GamesEntity>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull GamesEntity gamesWebOrbEntity) throws Exception {
                                Log.d("GamesDATA", gamesWebOrbEntity.getCurrency());
                                gamesView.initRecyclerView(gamesWebOrbEntity.getGameEntities());
                                gamesView.showToast(gamesWebOrbEntity.getGameEntities().toString());
                            }
                        }
                );
    }
}
