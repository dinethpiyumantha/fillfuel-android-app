package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

import edu.sliitead.fillfuelapp.adapters.FuelRecyclerAdapter;
import edu.sliitead.fillfuelapp.adapters.StationRecyclerAdapter;
import edu.sliitead.fillfuelapp.data.Fuel;

public class StationActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //Sample Arrays
    ArrayList<Fuel> fuelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_station);

        recyclerView = (RecyclerView) findViewById(R.id.rvFuelAvab);

        setArray();
        setAdapter();

    }

    private void setArray() {
        //Set array values
        fuelArrayList.add(new Fuel("OCTANE 92 Petrol"));
        fuelArrayList.add(new Fuel("OCTANE 95 Petrol"));
        fuelArrayList.add(new Fuel("Super Diesel"));
    }

    private void setAdapter() {
        FuelRecyclerAdapter recyclerAdapter = new FuelRecyclerAdapter(fuelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }
}