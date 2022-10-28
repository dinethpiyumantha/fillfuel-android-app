package edu.sliitead.fillfuelapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sliitead.fillfuelapp.R;
import edu.sliitead.fillfuelapp.data.FuelData;
import edu.sliitead.fillfuelapp.models.Fuel;

public class FuelRecyclerAdapter extends RecyclerView.Adapter<FuelRecyclerAdapter.MyViewHolder> {

    private ArrayList<FuelData> fuelArrayList;

    public FuelRecyclerAdapter(ArrayList<FuelData> arrayList) {
        this.fuelArrayList = arrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtFuelName, txtFuelStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFuelName = itemView.findViewById(R.id.txtFuelName);
            txtFuelStatus = itemView.findViewById(R.id.txtFuelStatus);
        }
    }

    @NonNull
    @Override
    public FuelRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fuel_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FuelRecyclerAdapter.MyViewHolder holder, int position) {
        String fuelName = fuelArrayList.get(position).getName();
        String fuelStatus = fuelArrayList.get(position).getStatus().toString();

        holder.txtFuelName.setText(fuelName);
        holder.txtFuelStatus.setText(fuelStatus);
    }

    @Override
    public int getItemCount() {
        return fuelArrayList.size();
    }


}
