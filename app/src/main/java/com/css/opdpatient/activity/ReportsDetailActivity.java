package com.css.opdpatient.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.ReportsDetailAdapter;
import com.css.opdpatient.database.DatabaseHelper;
import com.css.opdpatient.model.ReportsDetailModel;
import com.css.opdpatient.utils.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;

/***
 * Created By : Jyoti on 05 Feb 2018 (Monday)
 * Functionality : This will show the reports detail to the respective patient
 */
public class ReportsDetailActivity extends ParentActivity implements ReportsDetailAdapter.OpenCamera {
    String TAG = "ReportsDetailActivity";

    private RecyclerView recyclerReportsDetail;
    private RecyclerView.Adapter adapter;
    private ArrayList<ReportsDetailModel> arrayList = new ArrayList<ReportsDetailModel>();
    private LinearLayout llInflateImage;

    private final int CAMERA_REQUEST_PROFILE_PIC = 1;
    private final int SELECT_PICTURE_PROFILE_PIC = 2;
    private String binaryImage = "";
    private TextView txtReportsDetailsDate, txtReportsDetailsName;

    private DatabaseHelper databaseHelper;

    private int addImagePosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_detail);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();
    }//end of onCreate

    void initUIControls() {
        imgTopLeft = findViewById(R.id.imgTopLeft);

        recyclerReportsDetail = findViewById(R.id.recyclerReportsDetail);
        txtReportsDetailsDate = findViewById(R.id.txtReportsDetailsDate);
        txtReportsDetailsName = findViewById(R.id.txtReportsDetailsName);

    }//end of initUIControls

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_reportsdetail));
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void setAdapter() {

        String qry = "select * from report res inner join report_image resimg where res.id = resimg.id and res.id=" + getIntent().getStringExtra("report_id");
        Log.d(TAG, "setAdapter: " + qry);
        databaseHelper = DatabaseHelper.getInstance(this);
        Cursor cur = databaseHelper.getDataUsingCustomQuery(qry, null);

        if (cur.getCount() > 0) {
            cur.moveToFirst();

            for (int i = 0; i < cur.getCount(); i++) {
                ReportsDetailModel reportsDetailModel = new ReportsDetailModel();
                txtReportsDetailsDate.setText(getIntent().getStringExtra("date"));
                txtReportsDetailsName.setText(getIntent().getStringExtra("patient_name"));
                reportsDetailModel.setTestName(cur.getString(cur.getColumnIndex("description")));
                reportsDetailModel.setLabName(cur.getString(cur.getColumnIndex("lab_name")));
                reportsDetailModel.setPath(cur.getString(cur.getColumnIndex("image_path")));

                arrayList.add(reportsDetailModel);
                cur.moveToNext();
            }
        }
        adapter = new ReportsDetailAdapter(this, arrayList, this);
        recyclerReportsDetail.setLayoutManager(new LinearLayoutManager(this));
        recyclerReportsDetail.setAdapter(adapter);

    }

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(MyReportsActivity.class, false);
                break;

        }//end of switch case
    }//end of onClick()

    @Override
    public void openCamera(int position) {
        showToast("Clicked on btn" + position);
        addImagePosition = position;
        //selectImage(position);
        openCameraDialog();
    }

    private void openCameraDialog() {

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(ReportsDetailActivity.this);

        builder.setTitle("Add Photo!");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_REQUEST_PROFILE_PIC);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                    photoPickerIntent.setType("image/*");

                    startActivityForResult(photoPickerIntent, SELECT_PICTURE_PROFILE_PIC);

                } else if (options[item].equals("Cancel")) {

                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void selectImage(int position) {

        addImagePosition = position;
        ReportsDetailModel reportsDetailModel = arrayList.get(position);
        int count = reportsDetailModel.getImageCount();
        count++;
        reportsDetailModel.setImageCount(count);
        Log.d(TAG, "selectImage: " + reportsDetailModel.getImageCount());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "onActivityResult :: data :: " + data);

            if (data != null) {
                if (requestCode == CAMERA_REQUEST_PROFILE_PIC) {//profile from camera
                    browseImage(data);
                } else if (requestCode == SELECT_PICTURE_PROFILE_PIC) {//profile from gallery
                    uploadPicFromGallery(data, requestCode);
                }
            }
        }//end of resultCode if
    }//end of onActivityResult()


    //camera request handle
    private void browseImage(Intent data) {
        if (data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            String profilePicBinaryData = binaryImage = ImageUtils.encodeToBase64(bitmap);

            binaryImage = profilePicBinaryData;


            storeBinaryData(binaryImage);
            Log.d(TAG, "uploadPicFromCamera: " + binaryImage);

        }
    }//end of browseImage()

    //handle gallery request
    private void uploadPicFromGallery(Intent data, int requestCode) {
        Uri uri = data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            binaryImage = ImageUtils.encodeToBase64(bitmap);
            Log.d(TAG, "uploadPicFromGallery: " + binaryImage);
            storeBinaryData(binaryImage);


        } catch (IOException e) {
            showToast("Error in uploading your image please upload again ...!");
            e.printStackTrace();
        }

    }//end of uploadPicFromGallery()


    /***
     * will store binary data
     * @param binaryImage
     */
    private void storeBinaryData(String binaryImage) {
        ReportsDetailModel reportsDetailModel = arrayList.get(addImagePosition);
        int count = reportsDetailModel.getImageCount();
        count++;
        reportsDetailModel.setImageCount(count);
        reportsDetailModel.setPath(binaryImage);
        Log.d(TAG, "selectImage: " + reportsDetailModel.getImageCount());
        adapter.notifyDataSetChanged();
    }   //end of storeBinaryData
}//end of ReportsDetailActivity
