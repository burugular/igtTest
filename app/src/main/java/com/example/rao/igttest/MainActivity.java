package com.example.rao.igttest;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.View.FGameDetail;
import com.example.rao.igttest.Games.View.FGames;
import com.example.rao.igttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FGames.OnGameSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onGameSelected(GameEntity gameEntity) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FGameDetail gameDetailFrag = (FGameDetail) fragmentManager
                .findFragmentById(R.id.fragment_fGameDetail);
        Fragment gameFrag = fragmentManager.findFragmentById(R.id.fragment_fGames);
        if (gameDetailFrag == null) {
            // DisplayFragment (Fragment B) is not in the layout (handset layout),
            // so start DisplayActivity (Activity B)
            // and pass it the info about the selected item
//            Intent intent = new Intent(this, DisplayActivity.class);
//            intent.put("position", gameEntity);
//            startActivity(intent);
        } else {
            // DisplayFragment (Fragment B) is in the layout (tablet layout),
            // so tell the fragment to update
            //FGameDetail fGameDetail = new FGameDetail();
            gameDetailFrag.updateContent(gameEntity);
        }
    }
}
