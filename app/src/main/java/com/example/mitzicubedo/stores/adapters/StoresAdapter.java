package com.example.mitzicubedo.stores.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mitzicubedo.stores.R;
import com.example.mitzicubedo.stores.models.Store;

import java.util.List;


public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.StoreViewHolder> {

    private OnStoreClickListener mOnStoreClickListener;
    private List<Store> mStoresList;

    public StoresAdapter(List<Store> mStoresList, OnStoreClickListener listener){
        this.mStoresList = mStoresList;
        mOnStoreClickListener = listener;
    }

    @Override
    public StoreViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        StoreViewHolder viewHolder = new StoreViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoreViewHolder holder, int position) {
        Store store = mStoresList.get(position);
        holder.bind(store, position);
    }

    @Override
    public int getItemCount() {
        return mStoresList.size();
    }

    public class StoreViewHolder extends RecyclerView.ViewHolder   {

        private TextView mStoreNameTextView;

        public StoreViewHolder(View itemView) {
            super(itemView);
            mStoreNameTextView = (TextView) itemView.findViewById(R.id.store_name);
        }

        public void bind(final Store store, final int position){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnStoreClickListener.onStoreClick(store, position);
                }
            });

            mStoreNameTextView.setText(store.getName());
        }
    }

    public interface OnStoreClickListener {
        void onStoreClick(Store store, int position);
    }
}

