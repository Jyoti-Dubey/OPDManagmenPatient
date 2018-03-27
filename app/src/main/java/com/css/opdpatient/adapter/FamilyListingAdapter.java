package com.css.opdpatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.css.opdpatient.R;
import com.css.opdpatient.model.FamilyListingDataProvider;

import java.util.ArrayList;

/**
 * Created by jyoti on 25-01-2018.
 */

public class FamilyListingAdapter extends RecyclerView.Adapter<FamilyListingAdapter.RecyclerViewHolder> {

    private final String TAG = "FamilyListingAdapter";
    private Context context;
    private ArrayList<FamilyListingDataProvider> arrayList = new ArrayList<FamilyListingDataProvider>();


    public FamilyListingAdapter(Context context, ArrayList<FamilyListingDataProvider> arrayList) {

        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_family_member_listing, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        FamilyListingDataProvider familyListingDataProvider = arrayList.get(position);
        //holder.imgFamilyMemberListing.setImageResource(Integer.parseInt(familyListingDataProvider.getImgFamilyMemberListing()));
        holder.txtFamilyMemberListingPersonName.setText(familyListingDataProvider.getTxtFamilyMemberListingPersonName());
        holder.txtFamilyMemberListingRelation.setText(familyListingDataProvider.getTxtFamilyMemberListingRelation());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = "RecyclerViewHolder";
        //private ImageView imgFamilyMemberListing;
        private TextView txtFamilyMemberListingPersonName;
        private TextView txtFamilyMemberListingRelation;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            //imgFamilyMemberListing = (ImageView) itemView.findViewById(R.id.imgFamilyMemberListing);
            txtFamilyMemberListingPersonName =  itemView.findViewById(R.id.txtFamilyMemberListingPersonName);
            txtFamilyMemberListingRelation =  itemView.findViewById(R.id.txtFamilyMemberListingRelation);

            itemView.setOnClickListener(this);
        }//end of  RecyclerViewHolder method

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Item Position = " + getPosition(), Toast.LENGTH_SHORT).show();

        }
    }
}
