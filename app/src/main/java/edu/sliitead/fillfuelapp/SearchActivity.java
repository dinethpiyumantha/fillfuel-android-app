package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;

import edu.sliitead.fillfuelapp.adapters.StationRecyclerAdapter;
import edu.sliitead.fillfuelapp.data.Station;

public class SearchActivity extends AppCompatActivity {

    TextView txtSearchTitle, txtSearchResultTitle;
    RecyclerView recyclerView;

    //Sample Arrays
    ArrayList<Station> stationArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_search);

        stationArrayList = new ArrayList<>();

        //Set components
        txtSearchTitle = (TextView) findViewById(R.id.txtSearchTitle);
        txtSearchResultTitle = (TextView) findViewById(R.id.txtSearchResultTitle);
        recyclerView = (RecyclerView) findViewById(R.id.rvStationListSearch);

        setArray();
        setAdapter();

        //On click events
        txtSearchTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHome();
            }
        });

        txtSearchResultTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQueue();
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQueue();
            }
        });
    }

    private void showHome() {
        startActivity(new Intent(this, HomeActivity.class));
    }
    private void showQueue() {
        startActivity(new Intent(this, QueueActivity.class));
    }

    private void setArray() {
        //Set array values
        stationArrayList.add(new Station("Station 1", "Address 1", "Comp 1"));
        stationArrayList.add(new Station("Station 2", "Address 2", "Comp 2"));
        stationArrayList.add(new Station("Station 3", "Address 3", "Comp 3"));
    }

    private void setAdapter() {
        StationRecyclerAdapter recyclerAdapter = new StationRecyclerAdapter(stationArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }
}