package com.css.opdpatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.SelectDoctorModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.RecyclerViewHolder> {

    private final String TAG = "DoctorAdapter";
    private Context context;
    private OnClick onClick;
    private ArrayList<SelectDoctorModel> arrayList = new ArrayList<SelectDoctorModel>();


    public DoctorAdapter(Context context, ArrayList<SelectDoctorModel> arrayList, OnClick onClick) {
        this.arrayList = arrayList;
        this.context = context;
        this.onClick = onClick;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_doctor, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        final SelectDoctorModel selectDoctorModel = arrayList.get(position);

        if (selectDoctorModel.isSelected()) {
            holder.txtDoctorName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, context.getResources().getDrawable(R.drawable.radiobtn_active));

        } else {
            holder.txtDoctorName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, context.getResources().getDrawable(R.drawable.radiobtn_inactive));
        }

        holder.txtDoctorName.setText(selectDoctorModel.getTxtDoctorName());
        holder.txtDoctorSpecialist.setText(selectDoctorModel.getTxtDoctorSpecialist());

        Picasso.with(context)
                .load(selectDoctorModel.getImgDoctorImage())
                .placeholder(R.drawable.user_default_pic_large)
                .error(R.drawable.user_default_pic_large)
                .into(holder.imgDoctorImage);

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

        private ImageView imgDoctorImage;
        private TextView txtDoctorName;
        private TextView txtDoctorSpecialist;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txtDoctorName = itemView.findViewById(R.id.txtDoctorName);
            txtDoctorSpecialist = itemView.findViewById(R.id.txtDoctorSpecialist);
            imgDoctorImage = itemView.findViewById(R.id.imgDoctorImage);
        }//end of  RecyclerViewHolder method

    }

    public interface OnClick {
        public void clickPosition(int position);
    }
}
