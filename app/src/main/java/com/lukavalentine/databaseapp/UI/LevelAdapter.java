package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private List<LevelEntity> mLevels;

    public LevelAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    class LevelViewHolder extends RecyclerView.ViewHolder {

        private final TextView LevelItemView;
        private final TextView LevelItemView2;
        private final TextView LevelItemView3;

        private LevelViewHolder(View itemView) {
            super(itemView);
            LevelItemView = itemView.findViewById(R.id.LevelTextView);
            //Added additional LevelItemView2
            LevelItemView2 = itemView.findViewById(R.id.LevelTextView2);
            LevelItemView3 = itemView.findViewById(R.id.LevelTextView3);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final LevelEntity current = mLevels.get(position);
                    //
                    Intent intent = new Intent(context, LevelEdit.class);
                    intent.putExtra("LevelID", current.getLevelID());
                    intent.putExtra("LevelName", current.getLevelName());
                    intent.putExtra("LevelStart", current.getLevelStart());
                    intent.putExtra("LevelEnd", current.getLevelEnd());
                    intent.putExtra("position", position);
                    context.startActivity(intent);


                }
            });
        }
    }


    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.level_list_item, parent, false);
        return new LevelViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {

        if (mLevels != null) {
            final LevelEntity current = mLevels.get(position);
            holder.LevelItemView.setText(current.getLevelName());
            //Added additional LevelItemView2.
            holder.LevelItemView2.setText(current.getLevelStart());
            holder.LevelItemView3.setText(current.getLevelEnd());
        } else {
            holder.LevelItemView.setText("No Word");
        }

    }

    @Override
    public int getItemCount() {
        if (mLevels != null)
            return mLevels.size();
        else return 0;
    }

    public void setWords(List<LevelEntity> words) {
        mLevels = words;
        notifyDataSetChanged();
    }


}
