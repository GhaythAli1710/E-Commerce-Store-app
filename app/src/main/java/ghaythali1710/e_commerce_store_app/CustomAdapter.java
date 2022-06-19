package ghaythali1710.e_commerce_store_app;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RVHolder> implements Filterable {
    private final List<ClassObj> listData;
    private final int viewId;
    private final int textId;
    private final int imageId;
    private OnItemClickListenerCustom myListener;

    public CustomAdapter( List<ClassObj> listdata, int viewid, int textid, int imageid) {
        this.listData = listdata;
        this.viewId = viewid;
        this.textId = textid;
        this.imageId = imageid;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(viewId, null, false);
        return new RVHolder(view, textId, imageId, myListener);
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        ClassObj data = this.getItem(position);
        holder.getText().setText(data.getNameClass());
        holder.getImage().setImageResource(data.getImageId());
    }

    private ClassObj getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public int getItemCount() {
        return this.listData.size();
    }

    public void setOnItemClickListenerCustom(OnItemClickListenerCustom listener) {
        this.myListener = listener;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ClassObj> filteredList=new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(listData);
            }else{
                for (ClassObj data : listData){
                    if(data.getNameClass().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(data);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values =  filteredList;
            return filterResults;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData.clear();
            listData.addAll((Collection<? extends ClassObj>) results.values);
            notifyDataSetChanged();
        }
    };

}
