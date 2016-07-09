package com.example.kevinchen.foodebank.UI;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kevinchen.foodebank.Adapter.RecyclerAdapter;
import com.example.kevinchen.foodebank.Model.Site;
import com.example.kevinchen.foodebank.R;


/**
 * Created by kevinchen on 7/9/16.
 */
public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    Site[] mSites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_list);
        mSites = new Site[] {
                new Site("location1"),
                new Site("location2"),
                new Site("location3"),
                new Site("location4"),
                new Site("location5"),
                new Site("location6"),
                new Site("location7"),
                new Site("location8"),
                new Site("location9")
        };
        System.out.println("mSite is " + mSites.length);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycleView);
        mRecyclerView.setAdapter(new RecyclerAdapter(this, mSites));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }
}
