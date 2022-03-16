package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    private final Context context;
    private final LayoutInflater mInflater;
    private List<CourseEntity> mCourses;
    private List<CourseEntity> mfilteredCourses;


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
            holder.courseTextView2.setText(current.getCourseStart());
            holder.courseTextView3.setText(current.getCourseEnd());

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

//    @Override
//    public Filter getFilter() {
//        return searchFilter;
//    }
//
//    private final Filter searchFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            ArrayList<CourseEntity> filteredSearchList = new ArrayList<>();
//            if(constraint == null || constraint.length() == 0){
//                filteredSearchList.addAll(courseArrayListFull);
//            } else{
//                String filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim();
//                for (CourseEntity courses : courseArrayListFull){
//                    if (courses.getCourseName().toLowerCase(Locale.ROOT).contains(filterPattern))
//                        filteredSearchList.add(courses);
//                }
//            }
//
//            FilterResults results = new FilterResults();
//            results.values = filteredSearchList;
//            results.count = filteredSearchList.size();
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//
//            courseArrayList.clear();
//            courseArrayList.addAll((ArrayList)results.values);
//            notifyDataSetChanged();
//
//
//
//
//
//        }
//    };
//

    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseTextView;
        private final TextView courseTextView2;
        private final TextView courseTextView3;


        private CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTextView = itemView.findViewById(R.id.courseTextView);
            courseTextView2 = itemView.findViewById(R.id.courseTextView2);
            courseTextView3 = itemView.findViewById(R.id.courseTextView3);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final CourseEntity current = mCourses.get(position);

                    Intent intent = new Intent(context, CourseEdit.class);
                    intent.putExtra("courseID", current.getCourseID());
                    intent.putExtra("courseName", current.getCourseName());
                    intent.putExtra("courseMentor", current.getCourseMentor());
                    intent.putExtra("courseNote", current.getCourseNote());
                    intent.putExtra("courseStart", current.getCourseStart());
                    intent.putExtra("courseEnd", current.getCourseEnd());
                    intent.putExtra("courseStatus", current.getCourseStatus());
                    intent.putExtra("LevelID", current.getLevelID());
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

//    public void searchFilter(String text){
//        mCourses.clear();
//        if(text.isEmpty()){
//            mCourses.addAll(mfilteredCourses);
//        } else{
//            text = text.toLowerCase(Locale.ROOT);
//            for (CourseEntity c: mfilteredCourses){
//                if (c.getCourseName().toLowerCase(Locale.ROOT).contains(text)){
//                    mfilteredCourses.add(c);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }


}
