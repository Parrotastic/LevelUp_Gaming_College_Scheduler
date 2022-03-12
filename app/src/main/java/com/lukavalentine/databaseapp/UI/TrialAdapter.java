package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class TrialAdapter extends RecyclerView.Adapter<TrialAdapter.TrialViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private List<TrialEntity> mTrials;

    public TrialAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TrialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.trial_list_item, parent, false);
        return new TrialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrialViewHolder holder, int position) {
        if(mTrials != null){
            final TrialEntity current = mTrials.get(position);
            holder.TrialTextView.setText(current.getTrialName());
            holder.TrialTextView2.setText(current.getTrialStart());
            holder.TrialTextView3.setText(current.getTrialEnd());


        }
        else{
            holder.TrialTextView.setText("No Word");

        }

    }

    @Override
    public int getItemCount() {
        if(mTrials != null)
            return mTrials.size();
        else return 0;
    }

    public class TrialViewHolder extends RecyclerView.ViewHolder {
        private final TextView TrialTextView;
        private final TextView TrialTextView2;
        private final TextView TrialTextView3;


        public TrialViewHolder(@NonNull View itemView) {
            super(itemView);
            TrialTextView = itemView.findViewById(R.id.TrialTextView);
            TrialTextView2 = itemView.findViewById(R.id.TrialTextView2);
            TrialTextView3 = itemView.findViewById(R.id.TrialTextView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final TrialEntity current = mTrials.get(position);

                    Intent intent = new Intent(context, TrialEdit.class);
                    intent.putExtra("TrialID", current.getTrialID());
                    intent.putExtra("TrialName", current.getTrialName());
                    intent.putExtra("TrialStart", current.getTrialStart());
                    intent.putExtra("TrialEnd", current.getTrialEnd());
                    intent.putExtra("TrialType", current.getTrialType());
                    intent.putExtra("courseID", current.getCourseID());
                    intent.putExtra("position", position);
                    context.startActivity(intent);

                }
            });
        }

        private TextView getTrialTextView() {
            return TrialTextView;
        }
    }

    public void setWords(List<TrialEntity> words){
        mTrials = words;
        notifyDataSetChanged();
    }
}
