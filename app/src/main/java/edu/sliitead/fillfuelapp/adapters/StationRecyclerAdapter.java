package edu.sliitead.fillfuelapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sliitead.fillfuelapp.R;
import edu.sliitead.fillfuelapp.data.Station;

public class StationRecyclerAdapter extends RecyclerView.Adapter<StationRecyclerAdapter.MyViewHolder> {

    private ArrayList<Station> stationArrayList;

    public StationRecyclerAdapter(ArrayList<Station> arrayList) {
        this.stationArrayList = arrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtStationName, txtStationAddress, txtStationComp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStationName = itemView.findViewById(R.id.txtStationCardName);
            txtStationAddress = itemView.findViewById(R.id.txtStationCardAddress);
            txtStationComp = itemView.findViewById(R.id.txtStationCardComp);
        }
    }

    @NonNull
    @Override
    public StationRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StationRecyclerAdapter.MyViewHolder holder, int position) {
        String stationName = stationArrayList.get(position).getName();
        String stationAddress = stationArrayList.get(position).getAddress();
        String stationComp = stationArrayList.get(position).getCompany();

        holder.txtStationName.setText(stationName);
        holder.txtStationAddress.setText(stationAddress);
        holder.txtStationComp.setText(stationComp);
    }

    @Override
    public int getItemCount() {
        return stationArrayList.size();
    }
}
