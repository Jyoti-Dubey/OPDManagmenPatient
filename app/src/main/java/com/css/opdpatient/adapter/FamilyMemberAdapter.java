package com.css.opdpatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.FamilyMemberModelActivity;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.RecyclerViewHolder> {

    private final String TAG = "FamilyMemberAdapter";
    private Context context;
    private ArrayList<FamilyMemberModelActivity> arrayList = new ArrayList<FamilyMemberModelActivity>();


    public FamilyMemberAdapter(Context context, ArrayList<FamilyMemberModelActivity> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_family_member, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        FamilyMemberModelActivity familyMemberModelActivity = arrayList.get(position);
        Log.d(TAG, "Family memver name :: " + familyMemberModelActivity.getTxtFamilyMemberName().substring(0, 2));
        holder.txtFamilyMemberInitial.setText(familyMemberModelActivity.getTxtFamilyMemberName().substring(0, 2));
        holder.txtFamilyMemberName.setText(familyMemberModelActivity.getTxtFamilyMemberName());
        holder.txtFamilyMemberRelation.setText(familyMemberModelActivity.getTxtFamilyMemberRelation());
        holder.txtFamilyMemberPatientID.setText(familyMemberModelActivity.getTxtFamilyMemberPatientID());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView txtFamilyMemberInitial;
        private TextView txtFamilyMemberName;
        private TextView txtFamilyMemberRelation;
        private TextView txtFamilyMemberPatientID;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtFamilyMemberInitial = itemView.findViewById(R.id.txtFamilyMemberInitial);
            txtFamilyMemberName = itemView.findViewById(R.id.txtFamilyMemberName);
            txtFamilyMemberRelation = itemView.findViewById(R.id.txtFamilyMemberRelation);
            txtFamilyMemberPatientID = itemView.findViewById(R.id.txtFamilyMemberPatientID);

        }//end of  RecyclerViewHolder method

    }
}
