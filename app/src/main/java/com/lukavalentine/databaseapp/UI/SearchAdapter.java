package com.lukavalentine.databaseapp.UI;

import android.content.Context;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Entities.MentorEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private final Context context;
    private final LayoutInflater mInflater;
    ArrayList<MentorEntity> MentorsArrayList;
    ArrayList<MentorEntity> MentorsArrayListFull;



    public SearchAdapter(Context context, ArrayList<MentorEntity> MentorsArrayList){
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.MentorsArrayListFull = MentorsArrayList;
        this.MentorsArrayList = new ArrayList<>(MentorsArrayListFull);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.search_list_item, parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        MentorEntity Mentors = MentorsArrayList.get(position);
        holder.searchListTextView.setText(Mentors.getMentorName());
        holder.searchListTextView2.setText(Mentors.getMentorPhone());
        holder.searchListTextView3.setText(Mentors.getMentorEmail());



    }

    @Override
    public int getItemCount() {
        return MentorsArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return MentorsSearchFilter;
    }

    private final Filter MentorsSearchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<MentorEntity> filteredMentorsList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredMentorsList.addAll(MentorsArrayListFull);
            } else{

                String filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim();
                for (MentorEntity Mentors : MentorsArrayListFull){
                    if (Mentors.getMentorName().toLowerCase(Locale.ROOT).contains(filterPattern))
                        filteredMentorsList.add(Mentors);
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredMentorsList;
            results.count = filteredMentorsList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            MentorsArrayList.clear();
            MentorsArrayList.addAll((ArrayList) results.values);
            notifyDataSetChanged();

        }
    };

    class SearchViewHolder extends RecyclerView.ViewHolder{
        private final TextView searchListTextView;
        private final TextView searchListTextView2;
        private final TextView searchListTextView3;
       public SearchViewHolder(@NonNull View itemView) {
           super(itemView);
           searchListTextView = itemView.findViewById(R.id.searchListTextView);
           searchListTextView2 = itemView.findViewById(R.id.searchListTextView2);
           searchListTextView3 = itemView.findViewById(R.id.searchListTextView3);
       }
   }
}
