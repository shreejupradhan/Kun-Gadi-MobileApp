package com.example.sixth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sixth.Activities.ViewMyNodeContribution;
import com.example.sixth.Models.ConNodeInfo;
import com.example.sixth.R;

import java.util.ArrayList;

public class NodeContributionAdapter extends ArrayAdapter<ConNodeInfo> {
    Context context;
    String state;
    public NodeContributionAdapter(@NonNull Context context, ArrayList<ConNodeInfo> list) {
        super(context,0,list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent){

        View view= LayoutInflater.from(getContext()).inflate(R.layout.single_list_node_contribution,null);
        LinearLayout l1 = view.findViewById(R.id.listBox);

        TextView created = view.findViewById(R.id.con_date);
        TextView name = view.findViewById(R.id.con_name);
        TextView lat = view.findViewById(R.id.con_lat);
        TextView lng = view.findViewById(R.id.con_lng);
        ConNodeInfo info = getItem(position);
        Log.d( "inside adapter: ", String.valueOf(position));
        created.setText("Submitted On: "+info.getCreated());
        name.setText("Name: "+info.getName());
        lat.setText("Lat: "+info.getN_lat());
        lng.setText("Lat: "+info.getN_lng());

        state = info.getState_id();
        if(state.equals("1")){
            l1.setBackgroundResource(R.drawable.shape_green);
        }else if(state.equals("2")){
            l1.setBackgroundResource(R.drawable.shape_blue);
        }else{
            l1.setBackgroundResource(R.drawable.shape_white);
        }

        return view;
    }
}
