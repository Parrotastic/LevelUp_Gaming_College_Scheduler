package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.TermEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private List<TermEntity> mTerms;

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    class TermViewHolder extends RecyclerView.ViewHolder {

        private final TextView termItemView;
        private final TextView termItemView2;
        private final TextView termItemView3;

        private TermViewHolder(View itemView) {
            super(itemView);
            termItemView = itemView.findViewById(R.id.termTextView);
            //Added additional termItemView2
            termItemView2 = itemView.findViewById(R.id.termTextView2);
            termItemView3 = itemView.findViewById(R.id.termTextView3);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final TermEntity current = mTerms.get(position);
                    //
                    Intent intent = new Intent(context, TermEdit.class);
                    intent.putExtra("termID", current.getTermID());
                    intent.putExtra("termName", current.getTermName());
                    intent.putExtra("termStart", current.getTermStart());
                    intent.putExtra("termEnd", current.getTermEnd());
                    intent.putExtra("position", position);
                    context.startActivity(intent);


                }
            });
        }
    }


    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {

        if (mTerms != null) {
            final TermEntity current = mTerms.get(position);
            holder.termItemView.setText(current.getTermName());
            //Added additional termItemView2.
            holder.termItemView2.setText(current.getTermStart());
            holder.termItemView3.setText(current.getTermEnd());
        } else {
            holder.termItemView.setText("No Word");
        }

    }

    @Override
    public int getItemCount() {
        if (mTerms != null)
            return mTerms.size();
        else return 0;
    }

    public void setWords(List<TermEntity> words) {
        mTerms = words;
        notifyDataSetChanged();
    }


}
