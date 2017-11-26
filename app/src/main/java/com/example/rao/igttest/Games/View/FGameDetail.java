package com.example.rao.igttest.Games.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.Entity.GamesEntity;
import com.example.rao.igttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rao on 23/11/2017.
 */

public class FGameDetail extends Fragment implements GameDetailView {

    @BindView(R.id.tv_game_name)
    TextView tvName;
    @BindView(R.id.tv_jackpot)
    TextView tvJackpot;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_detail_layout, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void updateContent(GameEntity gameEntity) {
        tvName.setText(gameEntity.getName());
        tvJackpot.setText(gameEntity.getJackpot().toString());
    }
}
