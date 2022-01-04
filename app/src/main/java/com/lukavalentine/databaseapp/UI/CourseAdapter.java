package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private List<CourseEntity> mCourses;

    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        if (mCourses != null) {
            final CourseEntity current = mCourses.get(position);
            holder.courseTextView.setText(current.getCourseName());

        } else {
            holder.courseTextView.setText("No Word");

        }


    }

    @Override
    public int getItemCount() {

        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseTextView;


        private CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTextView = itemView.findViewById(R.id.courseTextView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final CourseEntity current = mCourses.get(position);

                    Intent intent = new Intent(context, CourseEdit.class);
                    intent.putExtra("courseID", current.getCourseID());
                    intent.putExtra("courseName", current.getCourseName());
                    intent.putExtra("courseInstructor", current.getCourseInstructor());
                    intent.putExtra("courseNote", current.getCourseNote());
                    intent.putExtra("courseStart", current.getCourseStart());
                    intent.putExtra("courseEnd", current.getCourseEnd());
                    intent.putExtra("termID", current.getTermID());
                    intent.putExtra("position", position);
                    context.startActivity(intent);

                }
            });

        }
    }

    public void setWords(List<CourseEntity> words) {
        mCourses = words;
        notifyDataSetChanged();
    }
}
