package com.lukavalentine.databaseapp.UI;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.R;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    class TermViewHolder extends RecyclerView.ViewHolder{

        private final TextView termItemView;

        private TermViewHolder(View itemView){
            super(itemView);
            termItemView = itemView.findViewById(R.id.termTextView);
        }
    }

    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
