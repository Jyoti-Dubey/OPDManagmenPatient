package com.css.opdpatient.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.css.opdpatient.R;
import com.css.opdpatient.activity.VisitsDetailActivity;
import com.css.opdpatient.model.VisitsModel;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.RecyclerViewHolder> {

    private final String TAG = "VisitsAdapter";
    private Context context;
    private ArrayList<VisitsModel> arrayList = new ArrayList<VisitsModel>();


    public VisitsAdapter(Context context, ArrayList<VisitsModel> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_visits, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        VisitsModel visitsModel = arrayList.get(position);
        Log.d(TAG, "Family memver name :: " + visitsModel.getTxtVisitsName().substring(0, 2));
        holder.txtVisitsInitial.setText(visitsModel.getTxtVisitsName().substring(0, 2));
        holder.txtVisitsName.setText(visitsModel.getTxtVisitsName());
        holder.txtVisitsRelation.setText(visitsModel.getTxtVisitsRelation());
        holder.txtVisitsDate.setText(visitsModel.getTxtVisitsDate());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView txtVisitsInitial;
        private TextView txtVisitsRelation;
        private TextView txtVisitsDate;
        private TextView txtVisitsName;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtVisitsInitial = itemView.findViewById(R.id.txtVisitsInitial);
            txtVisitsName = itemView.findViewById(R.id.txtVisitsName);
            txtVisitsRelation = itemView.findViewById(R.id.txtVisitsRelation);
            txtVisitsDate = itemView.findViewById(R.id.txtVisitsDate);

        }//end of  RecyclerViewHolder method

    }
}
