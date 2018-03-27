package com.css.opdpatient.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.ReportsDetailModel;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class ReportsDetailAdapter extends RecyclerView.Adapter<ReportsDetailAdapter.RecyclerViewHolder> {

    private final String TAG = "ReportsDetailAdapter";
    private Context context;
    private OpenCamera openCamera;
    private ArrayList<ReportsDetailModel> arrayList = new ArrayList<ReportsDetailModel>();
    int newHeight = 250; // New height in pixels
    int newWidth = 300; // New width in pixels


    public ReportsDetailAdapter(Context context, ArrayList<ReportsDetailModel> arrayList, OpenCamera openCamera) {

        this.arrayList = arrayList;
        this.context = context;
        this.openCamera = openCamera;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_reports_detail, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {

        ReportsDetailModel reportsDetailModel = arrayList.get(position);

        holder.txtTestName.setText(reportsDetailModel.getTestName());
        holder.txtLabName.setText(reportsDetailModel.getLabName());
        holder.btnReportsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera.openCamera(position);
            }
        });

        holder.llInflateImage.removeAllViews();

        Log.d(TAG, "selectImage: " + reportsDetailModel.getImageCount());

        for (int i = 0; i < reportsDetailModel.getImageCount(); i++) {

            ImageView imageView = new ImageView(context);
            holder.llInflateImage.addView(imageView);
            imageView.setImageResource(R.drawable.ico_addreport);
            imageView.requestLayout();
            imageView.getLayoutParams().height = newHeight;
            imageView.getLayoutParams().width = newWidth;
            imageView.setPadding(2, 2, 2, 2);
            byte[] decodedBytes = Base64.decode(reportsDetailModel.getPath(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final String TAG = "RecyclerViewHolder";
        private Button btnReportsDetail;
        private TextView txtTestName;
        private TextView txtLabName;
        private LinearLayout llInflateImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            btnReportsDetail = itemView.findViewById(R.id.btnReportsDetail);
            txtTestName = itemView.findViewById(R.id.txtTestName);
            txtLabName = itemView.findViewById(R.id.txtLabName);
            llInflateImage = itemView.findViewById(R.id.llInflateImage);

        }//end of  RecyclerViewHolder method

    }//end of RecyclerViewHolder class

    public interface OpenCamera {
        public void openCamera(int position);
    }


}
