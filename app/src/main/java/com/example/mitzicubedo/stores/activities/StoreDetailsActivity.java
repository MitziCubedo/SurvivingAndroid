package com.example.mitzicubedo.stores.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mitzicubedo.stores.R;
import com.example.mitzicubedo.stores.adapters.StoreInfoAdapter;
import com.example.mitzicubedo.stores.models.StoreInfo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreDetailsActivity extends Activity {

    public static final String EXTRA_STORE_URL = "EXTRA_STORE_URL";

    List<StoreInfo> mStoreDetails = new ArrayList<>();
    RecyclerView mRecyclerViewInfo;
    String mStoreUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        if (getIntent().hasExtra(EXTRA_STORE_URL)) {
            mStoreUrl = getIntent().getStringExtra(EXTRA_STORE_URL);
        } else {
            finish();
        }

        mRecyclerViewInfo = (RecyclerView) findViewById(R.id.card_store_info_list);
        LinearLayoutManager storeRows = new LinearLayoutManager(this);
        storeRows.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewInfo.setLayoutManager(storeRows);

        new StoreAsyncTask().execute(mStoreUrl);
    }

    public class StoreAsyncTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(params[0]);
                HttpResponse response = client.execute(post);

                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);

                JSONObject JObjStore = new JSONObject(data);
                JSONArray JAStores = JObjStore.getJSONArray("data");

                for (int i = 0; i <= JAStores.length() - 1; i++) {
                    StoreInfo storeInfo = new StoreInfo();

                    JSONObject JOStore = JAStores.getJSONObject(i);
                    storeInfo.setDate(JOStore.getString("created_time"));
                    storeInfo.setMessage(JOStore.getString("message"));
                    mStoreDetails.add(storeInfo);
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            StoreInfoAdapter storeInfoAdapter = new StoreInfoAdapter(mStoreDetails);
            mRecyclerViewInfo.setAdapter(storeInfoAdapter);

        }
    }
}

