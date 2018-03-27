package com.css.opdpatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.BranchModel;
import com.css.opdpatient.model.FamilyMemberModelActivity;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.RecyclerViewHolder> {

    private final String TAG = "BranchAdapter";
    private Context context;
    private OnClick onClick;
    private ArrayList<BranchModel> arrayList = new ArrayList<BranchModel>();


    public BranchAdapter(Context context, ArrayList<BranchModel> arrayList, OnClick onClick) {
        this.arrayList = arrayList;
        this.context = context;
        this.onClick = onClick;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_branch, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        BranchModel branchModel = arrayList.get(position);

        if (branchModel.isSelected()) {
            holder.txtBranchName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, context.getResources().getDrawable(R.drawable.radiobtn_active));

        } else {
            holder.txtBranchName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, context.getResources().getDrawable(R.drawable.radiobtn_inactive));
        }
        holder.txtBranchName.setText(branchModel.getTxtBranchName());
        holder.txtBranchPlace.setText(branchModel.getTxtBranchPlace());
        holder.txtBranchNumber.setText(branchModel.getTxtBranchNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.clickPosition(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView txtBranchName;
        private TextView txtBranchPlace;
        private TextView txtBranchNumber;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtBranchName = itemView.findViewById(R.id.txtBranchName);
            txtBranchPlace = itemView.findViewById(R.id.txtBranchPlace);
            txtBranchNumber = itemView.findViewById(R.id.txtBranchNumber);

        }//end of  RecyclerViewHolder method

    }
    public interface OnClick {
        public void clickPosition(int position);
    }
}
