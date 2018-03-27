package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.squareup.picasso.Picasso;

/**
 * Created By : Jyoti on 01 Feb 2018 (Thrusday)
 * Functionality : This class will show the Members booked their token in step 2
 * Nevigation :move towards confirm token
 */
public class BookTokenStep_2Activity extends ParentActivity implements View.OnClickListener {

    private final String TAG = "BookTokenStep_2Activity";


    private Button btnBookToken2;
    private LinearLayout llInflateBookToken2;
    private String[] relation = {"Cousin", "Sister-in-law", "Sister", "Nephew"};
    private String[] names = {"Rupam Mishra", "Rennu Dubey", "Raushni Dubey", "Sikha Singh"};
    // private String[] images = {"https://randomuser.me/api/portraits/men/23.jpg", "https://randomuser.me/api/portraits/women/94.jpg", "https://randomuser.me/api/portraits/men/67.jpg", "https://randomuser.me/api/portraits/women/12.jpg"};
    private TextView txtName;
    private ImageView imgBookToken2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_token_step_2);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();


    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);
        txtName = findViewById(R.id.txtName);
        btnBookToken2 = findViewById(R.id.btnBookToken2);
        llInflateBookToken2 = findViewById(R.id.llInflateBookToken2);
        imgBookToken2 = findViewById(R.id.imgBookToken2);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnBookToken2.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();

        /*txtName.setText(PreferenceData.getStringPreference(BookTokenStep_2Activity.this, NAME));
        Log.d(TAG, "setUIData: " + PreferenceData.getStringPreference(BookTokenStep_2Activity.this, NAME));*/

        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtName.isSelected()) {
                    txtName.setTextColor(getResources().getColor(R.color.black));
                    txtName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.radiobtn_inactive), null);
                    txtName.setSelected(false);
                } else {
                    txtName.setTextColor(getResources().getColor(R.color.black));
                    txtName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.radiobtn_active), null);
                    txtName.setSelected(true);
                }
            }
        });


        txtTopCenter.setText(getResources().getString(R.string.top_booktoken2));
        Picasso.with(this).load("https://randomuser.me/api/portraits/men/9.jpg").into(imgBookToken2);

        //dynamically adding layouts in Book Token2
        LinearLayout llInflateBookToken2 = (LinearLayout) findViewById(R.id.llInflateBookToken2);

        final TextView txtSelectPatientName[] = new TextView[names.length];
        final TextView txtSelectPatientRelation[] = new TextView[relation.length];
        final TextView txtSelectPatient[] = new TextView[names.length];


        for (int j = 0; j < names.length; j++) {

            View newView = LayoutInflater.from(this).inflate(R.layout.book_token2, null);
            txtSelectPatientName[j] = newView.findViewById(R.id.txtSelectPatientName);
            txtSelectPatientName[j].setText(names[j]);

            txtSelectPatientRelation[j] = newView.findViewById(R.id.txtSelectPatientRelation);
            txtSelectPatientRelation[j].setText(relation[j]);

            txtSelectPatient[j] = newView.findViewById(R.id.txtSelectPatient);
            txtSelectPatient[j].setText(names[j].substring(0, 2));

            setBackgroundColor(j, txtSelectPatient[j]);

            llInflateBookToken2.addView(newView);


            final int finalJ = j;
            txtSelectPatientName[finalJ].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //showToast("click " + finalJ);
                    txtSelectPatientName[finalJ].setTextColor(getResources().getColor(R.color.black));
                    txtSelectPatientName[finalJ].setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.radiobtn_active), null);

                    for (int k = 0; k < names.length; k++) {
                        if (k == finalJ) {
                            continue;
                        }
                        txtSelectPatientName[k].setTextColor(getResources().getColor(R.color.black));
                        txtSelectPatientName[k].setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.radiobtn_inactive), null);
                    }
                }
            });
        }
    }

    /**
     * @param j
     * @param txtSelectPatient
     */
    private void setBackgroundColor(int j, TextView txtSelectPatient) {
        Log.d(TAG, "setUIData: " + j % 4);
        if (j % 4 == 0) {
            txtSelectPatient.setBackground(getResources().getDrawable(R.drawable.family_member_florosent_blue));
        } else if (j % 4 == 1) {
            txtSelectPatient.setBackground(getResources().getDrawable(R.drawable.family_member_yellow));
        } else if (j % 4 == 2) {
            txtSelectPatient.setBackground(getResources().getDrawable(R.drawable.family_member_purple));
        } else {
            txtSelectPatient.setBackground(getResources().getDrawable(R.drawable.family_member_violet));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnBookToken2:
                Intent intent = new Intent(BookTokenStep_2Activity.this, BookToken_3Activity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;
        }

    }//end of onClick()
}//end of BookTokenStep_2Activity
