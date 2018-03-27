package com.css.opdpatient.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.activity.ReportsDetailActivity;
import com.css.opdpatient.model.MyReportsModelActivity;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class MyReportsAdapter extends RecyclerView.Adapter<MyReportsAdapter.RecyclerViewHolder> {

    private final String TAG = "MyReportsAdapter";
    private Context context;
    private ArrayList<MyReportsModelActivity> arrayList = new ArrayList<MyReportsModelActivity>();


    public MyReportsAdapter(Context context, ArrayList<MyReportsModelActivity> arrayList) {

        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_my_reports, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final MyReportsModelActivity myReportsModelActivity = arrayList.get(position);

        holder.txtMyReportsDate.setText(myReportsModelActivity.getTxtMyReportsDate());
        holder.txtMyReportsDisease.setText(myReportsModelActivity.getTxtMyReportsDisease());
        holder.txtMyReportsName.setText(myReportsModelActivity.getTxtMyReportsName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(context, ReportsDetailActivity.class);
                intent.putExtra("report_id", myReportsModelActivity.getId());
                intent.putExtra("date",myReportsModelActivity.getTxtMyReportsDate());
                intent.putExtra("patient_name",myReportsModelActivity.getTxtMyReportsName());
                context.startActivity(intent);
            }
        });
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final String TAG = "RecyclerViewHolder";

        private TextView txtMyReportsDate;
        private TextView txtMyReportsDisease;
        private TextView txtMyReportsName;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txtMyReportsDate = itemView.findViewById(R.id.txtMyReportsDate);
            txtMyReportsDisease = itemView.findViewById(R.id.txtMyReportsDisease);
            txtMyReportsName= itemView.findViewById(R.id.txtMyReportsName);
        }//end of  RecyclerViewHolder method
    }
}
