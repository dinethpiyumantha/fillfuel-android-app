package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

import edu.sliitead.fillfuelapp.adapters.FuelRecyclerAdapter;
import edu.sliitead.fillfuelapp.data.FuelData;
import edu.sliitead.fillfuelapp.models.Fuel;
import edu.sliitead.fillfuelapp.services.FuelExternalAPICalls;

public class StationActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //Sample Arrays
    ArrayList<FuelData> fuelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_station);

        fuelArrayList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.rvFuelAvab);

        setArray();
        setAdapter();
    }

    private void setArray() {
        fuelArrayList.add(new FuelData("OCATNE 95 Petrol"));
        fuelArrayList.add(new FuelData("OCATNE 92 Petrol"));
        fuelArrayList.add(new FuelData("LK Super Diesel"));
    }

    private void setAdapter() {
        FuelRecyclerAdapter recyclerAdapter = new FuelRecyclerAdapter(fuelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void showQueue() {
        startActivity(new Intent(this, QueueActivity.class));
    }
}