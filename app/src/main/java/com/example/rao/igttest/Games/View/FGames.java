package com.example.rao.igttest.Games.View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.Presenter.GamesPresenter;
import com.example.rao.igttest.Games.Presenter.GamesPresenterImpl;
import com.example.rao.igttest.MainActivity;
import com.example.rao.igttest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rao on 21/11/2017.
 */

public class FGames extends Fragment implements GamesView {

    @BindView(R.id.rv_games)
    RecyclerView rvGames;
    private GamesAdapter gamesAdapter;
    private GamesPresenter presenter;
    OnGameSelectedListener mListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.games_layout, container, false);
        ButterKnife.bind(this, view);
        presenter = new GamesPresenterImpl(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnGameSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mListener = (OnGameSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.initUi();
    }

    @Override
    public void initRecyclerView(List<GameEntity> gameEntities) {
        gamesAdapter = new GamesAdapter(getActivity(), presenter, gameEntities);
        rvGames.setAdapter(gamesAdapter);
        rvGames.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClick(GameEntity gameEntity) {
        mListener.onGameSelected(gameEntity);
    }

    public interface OnGameSelectedListener{
        public void onGameSelected(GameEntity gameEntity);
    }
}
