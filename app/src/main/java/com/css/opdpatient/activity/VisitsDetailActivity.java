package com.css.opdpatient.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;

/***
 * Created By : Jyoti on 20 Feb 2018 (Tuesday)
 * Functionality : This will show the details visits of the the patient
 */
public class VisitsDetailActivity extends ParentActivity {
    private String TAG = "VisitsDetailActivity";

    private LinearLayout llVisitPatient, llInflateImageLabTest;
    private TextView txtBP[], txtBPView[];
    private Button btnVisitLabTest;
    private Bitmap currentImage;
    private String binaryImage = "";
    int newHeight = 400; // New height in pixels
    int newWidth = 400; // New width in pixels

    private String imagePostion = "";
    private String testName[] = {"  BP", " Temp", " Pul", "SPO2", " HT"};
    private String testValue[] = {"  7.5", " 37.5C", " 80", "    97 ", "   5.8 "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits_detail);

        String[] PERMISSIONS = {Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        ActivityCompat.requestPermissions(this, PERMISSIONS, 200);

        initUIControls();

        initTopBarComponents();

        bindVitalLayout();

        registerForListener();

        setUIData();

        getIntentData();

    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);
        llVisitPatient = findViewById(R.id.llVisitPatient);

        btnVisitLabTest = findViewById(R.id.btnVisitLabTest);
        llInflateImageLabTest = findViewById(R.id.llInflateImageLabTest);
    }//end of initUIControls

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }//end of initTopBarComponents

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_VisitDetail));
    }//end of setUIData

    /**
     * this will bind Vital checkups of the patient
     */
    private void bindVitalLayout() {
        txtBP = new TextView[testValue.length];
        txtBPView = new TextView[testValue.length];

        for (int i = 0; i < testValue.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.vital_visit_details, null);
            txtBP[i] = view.findViewById(R.id.txtBP);
            txtBPView[i] = view.findViewById(R.id.txtBPView);
            txtBP[i].setText(testName[i]);
            txtBPView[i].setText(testValue[i]);
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llVisitPatient.addView(view);
        }
    }//end of bindVitalLayout

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopLeft.setOnClickListener(this);
        btnVisitLabTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.imgTopLeft:
                onPreviousView();
                break;

            case R.id.btnVisitLabTest:
                openCameraDialog();
                break;
        }
    }//end of onClick

    @Override
    void getIntentData() {
        super.getIntentData();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtTopCenter.setText(extras.getString("name"));
        }
    }

    /**
     * This will open the camera and gallery to add the records
     */
    private void openCameraDialog() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(VisitsDetailActivity.this);

        builder.setTitle("Add Photo!");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo"))

                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, 1);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, 2);
                } else if (options[item].equals("Cancel")) {

                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }//end of openCameraDialog


    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (reqCode == 1) {

                Bitmap photo = (Bitmap) data.getExtras().get("data");

                for (int i = 0; i < 1; i++) {

                    ImageView imageView = new ImageView(this);
                    llInflateImageLabTest.addView(imageView);
                    imageView.setImageResource(R.drawable.ico_addreport);
                    imageView.requestLayout();
                    imageView.getLayoutParams().height = newHeight;
                    imageView.getLayoutParams().width = newWidth;
                    imageView.setPadding(2, 2, 2, 2);

                    imageView.setImageBitmap(photo);
                }

            } else if (reqCode == 2) {

                Uri photoUri = data.getData();
                if (photoUri != null) {
                    try {
                        currentImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
                        for (int i = 0; i < 3; i++) {

                            ImageView imageView = new ImageView(this);
                            llInflateImageLabTest.addView(imageView);
                            imageView.setImageResource(R.drawable.ico_addreport);
                            imageView.requestLayout();
                            imageView.getLayoutParams().height = newHeight;
                            imageView.getLayoutParams().width = newWidth;
                            imageView.setPadding(2, 2, 2, 2);

                            imageView.setImageBitmap(currentImage);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }//end of onActivityResult

    public void onStop() {
        super.onStop();
        if (currentImage != null) {
            currentImage.recycle();
            currentImage = null;
            System.gc();
        }
    }//end of onStop
}//end of VisitsDetailActivity
