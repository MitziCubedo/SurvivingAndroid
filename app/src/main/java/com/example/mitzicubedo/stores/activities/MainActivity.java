package com.example.mitzicubedo.stores.activities;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mitzicubedo.stores.R;
import com.example.mitzicubedo.stores.models.Store;
import com.example.mitzicubedo.stores.adapters.StoresAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements StoresAdapter.OnStoreClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView storesRecyclerView = (RecyclerView) findViewById(R.id.store_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //inside the recycler view
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        storesRecyclerView.setLayoutManager(layoutManager);

        StoresAdapter storesAdapter = new StoresAdapter(getStoreList(), this);
        storesRecyclerView.setAdapter(storesAdapter);
    }

    private List<Store> getStoreList() {
        List<Store> storeList = new ArrayList<>();

        Store store = new Store();
        store.setName("Bershka");
        store.setUrl("http://www.momenttr.com/smarttie/urban/api/bershka.json");
        storeList.add(store);

        store = new Store();
        store.setName("Pull & Bear");
        store.setUrl("http://www.momenttr.com/smarttie/urban/api/pull_bear.json");
        storeList.add(store);

        store = new Store();
        store.setName("Stradivarius");
        store.setUrl("35320546458");
        storeList.add(store);

        store = new Store();
        store.setName("Zara");
        store.setUrl("33331950906");
        storeList.add(store);

        store = new Store();
        store.setName("Abercrombie & Fitch");
        store.setUrl("25601085377");
        storeList.add(store);

        store = new Store();
        store.setName("American Eagle");
        store.setUrl("450326288368607");
        storeList.add(store);

        store = new Store();
        store.setName("Forever21");
        store.setUrl("771582112931229");
        storeList.add(store);

        store = new Store();
        store.setName("H & M");
        store.setUrl("21415640912");
        storeList.add(store);

        store = new Store();
        store.setName("Hollister");
        store.setUrl("115473663740");
        storeList.add(store);

        store = new Store();
        store.setName("LOB");
        store.setUrl("198508090036");
        storeList.add(store);

        store = new Store();;
        store.setName("Shasa");
        store.setUrl("135896883153359");
        storeList.add(store);

        return storeList;
    }

    @Override
    public void onStoreClick(Store store, int position) {
        Intent intent = new Intent(this, StoreDetailsActivity.class);
        intent.putExtra(StoreDetailsActivity.EXTRA_STORE_URL, store.getUrl());
        startActivity(intent);
    }
}