package com.css.opdpatient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.css.opdpatient.R;
import com.css.opdpatient.model.BookToken2ModelActivity;

import java.util.ArrayList;

/**
 * Created by jyoti on 01-02-2018.
 */

public class BookToken2AdapterActivity extends RecyclerView.Adapter<BookToken2AdapterActivity.RecyclerViewHolder> {

    private final String TAG = "BookToken2AdapterActivity";
    private Context context;
    private ArrayList<BookToken2ModelActivity> arrayList = new ArrayList<BookToken2ModelActivity>();


    public BookToken2AdapterActivity(Context context, ArrayList<BookToken2ModelActivity> arrayList) {

        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_book_token_step_2, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        BookToken2ModelActivity bookToken2ModelActivity = arrayList.get(position);
        //holder.imgFamilyMemberListing.setImageResource(Integer.parseInt(familyListingDataProvider.getImgFamilyMemberListing()));
        holder.txtRecyclerBookToken2Name.setText(bookToken2ModelActivity.getTxtRecyclerBookToken2Name());
        holder.txtRecyclerBookToken2Relation.setText(bookToken2ModelActivity.getTxtRecyclerBookToken2Relation());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = "RecyclerViewHolder";

        private TextView txtRecyclerBookToken2Name;
        private TextView txtRecyclerBookToken2Relation;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txtRecyclerBookToken2Name =  itemView.findViewById(R.id.txtRecyclerBookToken2Name);
            txtRecyclerBookToken2Relation =  itemView.findViewById(R.id.txtRecyclerBookToken2Relation);

            itemView.setOnClickListener(this);
        }//end of  RecyclerViewHolder method

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Item Position = " + getPosition(), Toast.LENGTH_SHORT).show();

        }
    }
}//end of BookToken2AdapterActivity
