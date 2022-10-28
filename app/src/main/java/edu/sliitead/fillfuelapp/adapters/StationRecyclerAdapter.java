package edu.sliitead.fillfuelapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.Buffer;
import java.util.ArrayList;

import edu.sliitead.fillfuelapp.R;
import edu.sliitead.fillfuelapp.StationActivity;
import edu.sliitead.fillfuelapp.data.Station;

public class StationRecyclerAdapter
        extends RecyclerView.Adapter<StationRecyclerAdapter.MyViewHolder> {

    private ArrayList<Station> stationArrayList;
    private Context context;

    public StationRecyclerAdapter(ArrayList<Station> arrayList, Context cntx) {
        this.stationArrayList = arrayList;
        this.context = cntx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtStationName, txtStationAddress, txtStationComp;
        private Button btnJoinQueue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStationName = itemView.findViewById(R.id.txtStationCardName);
            txtStationAddress = itemView.findViewById(R.id.txtStationCardAddress);
            txtStationComp = itemView.findViewById(R.id.txtStationCardComp);
            btnJoinQueue = itemView.findViewById(R.id.btnStationCardJoin);
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
