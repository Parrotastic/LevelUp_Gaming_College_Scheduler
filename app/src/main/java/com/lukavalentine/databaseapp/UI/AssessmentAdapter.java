package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private List<AssessmentEntity> mAssessments;

    public AssessmentAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.assessment_list_item, parent, false);
        return new AssessmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
        if(mAssessments != null){
            final AssessmentEntity current = mAssessments.get(position);
            holder.assessmentTextView.setText(current.getAssessmentID());


        }
        else{
            holder.assessmentTextView.setText("No Word");

        }

    }

    @Override
    public int getItemCount() {
        if(mAssessments != null)
            return mAssessments.size();
        else return 0;
    }

    public class AssessmentViewHolder extends RecyclerView.ViewHolder {
        private final TextView assessmentTextView;


        public AssessmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assessmentTextView = itemView.findViewById(R.id.assessmentTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final AssessmentEntity current = mAssessments.get(position);

                    Intent intent = new Intent(context, AssessmentEdit.class);
                    intent.putExtra("assessmentID", current.getAssessmentID());
                    intent.putExtra("assessmentName", current.getAssessmentName());
                    intent.putExtra("assessmentStart", current.getAssessmentStart());
                    intent.putExtra("assessmentEnd", current.getAssessmentEnd());
                    intent.putExtra("courseID", current.getCourseID());
                    intent.putExtra("position", position);
                    context.startActivity(intent);

                }
            });
        }

        private TextView getAssessmentTextView() {
            return assessmentTextView;
        }
    }

    public void setWords(List<AssessmentEntity> words){
        mAssessments = words;
        notifyDataSetChanged();
    }
}
