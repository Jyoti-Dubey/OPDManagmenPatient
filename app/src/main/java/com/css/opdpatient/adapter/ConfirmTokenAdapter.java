package com.css.opdpatient.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.ConfirmTokenModel;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class ConfirmTokenAdapter extends RecyclerView.Adapter<ConfirmTokenAdapter.RecyclerViewHolder> {

    private final String TAG = "ConfirmTokenAdapter";
    private Context context;
    private ArrayList<ConfirmTokenModel> arrayList = new ArrayList<ConfirmTokenModel>();


    public ConfirmTokenAdapter(Context context, ArrayList<ConfirmTokenModel> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_confirm_token, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ConfirmTokenModel confirmTokenModel = arrayList.get(position);

        holder.txtConfirmName.setText(confirmTokenModel.getTxtConfirmName());
        holder.txtConfirmRelation.setText(confirmTokenModel.getTxtConfirmRelation());
        holder.txtConfirmPatientID.setText(confirmTokenModel.getTxtConfirmPatientID());
        holder.txtConfirmTokenView.setText(confirmTokenModel.getTxtConfirmTokenView());
        holder.txtConfirmEstimatedTimeView.setText(confirmTokenModel.getTxtConfirmEstimatedTimeView());
        holder.txtConfirmCurrentView.setText(confirmTokenModel.getTxtConfirmCurrentView());
        holder.txtConfirmDoctorView.setText(confirmTokenModel.getTxtConfirmDoctorView());
        holder.txtConfirmClinicView.setText(confirmTokenModel.getTxtConfirmClinicView());
        holder.txtCancleToken.setPaintFlags(holder.txtCancleToken.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        holder.txtConfirmInitial.setText(confirmTokenModel.getTxtConfirmName().substring(0, 2));
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView txtConfirmInitial;
        private TextView txtConfirmName;
        private TextView txtConfirmRelation;
        private TextView txtConfirmPatientID;
        private TextView txtConfirmTokenView;
        private TextView txtConfirmEstimatedTimeView;
        private TextView txtConfirmCurrentView;
        private TextView txtConfirmDoctorView;
        private TextView txtConfirmClinicView;
        private TextView txtCancleToken;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txtConfirmInitial = itemView.findViewById(R.id.txtConfirmInitial);
            txtConfirmName = itemView.findViewById(R.id.txtConfirmName);
            txtConfirmRelation = itemView.findViewById(R.id.txtConfirmRelation);
            txtConfirmPatientID = itemView.findViewById(R.id.txtConfirmPatientID);
            txtConfirmTokenView = itemView.findViewById(R.id.txtConfirmTokenView);
            txtConfirmEstimatedTimeView = itemView.findViewById(R.id.txtConfirmEstimatedTimeView);
            txtConfirmCurrentView = itemView.findViewById(R.id.txtConfirmCurrentView);
            txtConfirmDoctorView = itemView.findViewById(R.id.txtConfirmDoctorView);
            txtConfirmClinicView = itemView.findViewById(R.id.txtConfirmClinicView);
            txtCancleToken = itemView.findViewById(R.id.txtCancleToken);


        }//end of  RecyclerViewHolder method

    }
}
