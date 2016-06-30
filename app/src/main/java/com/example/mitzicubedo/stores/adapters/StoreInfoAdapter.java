package com.example.mitzicubedo.stores.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mitzicubedo.stores.R;
import com.example.mitzicubedo.stores.models.StoreInfo;

import java.util.List;

/**
 * Created by MitziCubedo on 29/06/16.
 */
public class StoreInfoAdapter extends RecyclerView.Adapter<StoreInfoAdapter.StoreInfoViewHolder> {
    private List<StoreInfo> storeInfoList;
    public StoreInfoAdapter(List<StoreInfo> storeInfoList){
        this.storeInfoList = storeInfoList;
    }


    @Override
    public StoreInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store_detail, parent, false);

        return new StoreInfoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StoreInfoViewHolder holder, int position) {
        StoreInfo storeInfo = storeInfoList.get(position);

        holder.message.setText(storeInfo.getMessage());
        holder.date.setText(storeInfo.getDate());
    }

    @Override
    public int getItemCount() {
        return storeInfoList.size();
    }

    public class StoreInfoViewHolder extends RecyclerView.ViewHolder {
        protected TextView message;
        protected TextView date;


        public StoreInfoViewHolder(View itemView) {
            super(itemView);

            message = (TextView) itemView.findViewById(R.id.message);
            date = (TextView) itemView.findViewById(R.id.message_date);
        }
    }
}
