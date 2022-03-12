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

import com.lukavalentine.databaseapp.Entities.EventEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private final Context context;
    private final LayoutInflater mInflater;
    ArrayList<EventEntity> eventsArrayList;
    ArrayList<EventEntity> eventsArrayListFull;



    public SearchAdapter(Context context, ArrayList<EventEntity> eventsArrayList){
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayListFull = eventsArrayList;
        this.eventsArrayList = new ArrayList<>(eventsArrayListFull);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.search_list_item, parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        EventEntity events = eventsArrayList.get(position);
        holder.searchListTextView.setText(events.getEventName());
        holder.searchListTextView2.setText(events.getEventDate());



    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return eventsSearchFilter;
    }

    private final Filter eventsSearchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<EventEntity> filteredEventsList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredEventsList.addAll(eventsArrayListFull);
            } else{

                String filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim();
                for (EventEntity events : eventsArrayListFull){
                    if (events.getEventName().toLowerCase(Locale.ROOT).contains(filterPattern))
                        filteredEventsList.add(events);
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredEventsList;
            results.count = filteredEventsList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            eventsArrayList.clear();
            eventsArrayList.addAll((ArrayList) results.values);
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
