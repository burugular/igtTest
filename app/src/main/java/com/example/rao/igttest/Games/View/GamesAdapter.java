package com.example.rao.igttest.Games.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rao.igttest.Games.Entity.GameEntity;
import com.example.rao.igttest.Games.Presenter.GamesPresenter;
import com.example.rao.igttest.Games.Presenter.GamesPresenterImpl;
import com.example.rao.igttest.R;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rao on 21/11/2017.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private LayoutInflater layoutInflater;
    private List<GameEntity> data = Collections.emptyList();
    Context context;
    GamesPresenter gamesPresenter;

    public GamesAdapter(Context context, GamesPresenter gamesPresenter, List<GameEntity> gameEntities) {
        layoutInflater = LayoutInflater.from(context);
        this.data = gameEntities;
        this.context = context;
        this.gamesPresenter = gamesPresenter;
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.games_row, parent, false);
        GamesViewHolder viewHolder = new GamesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        GameEntity entity = data.get(position);
        holder.tvName.setText(entity.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GamesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.row_container)
        RelativeLayout rowContainer;
        @BindView(R.id.tv_name)
        TextView tvName;
        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.row_container)
        void rowClick(){
            //GamesPresenter gamesPresenter = new GamesPresenterImpl();
            gamesPresenter.showGameDetail(data.get(getLayoutPosition()));
            Toast.makeText(context, "itemClicked " + data.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
        }

    }
}
