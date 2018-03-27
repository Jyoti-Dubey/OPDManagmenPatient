package com.css.opdpatient.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.css.opdpatient.R;
import com.css.opdpatient.utils.PreferenceData;
import com.css.opdpatient.webservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.css.opdpatient.utils.PreferenceData.mobile_number;
import static com.css.opdpatient.utils.PreferenceData.password;
import static com.css.opdpatient.utils.PreferenceData.patient_id;

/**
 * Created By : Jyoti on 22 Jan 2018 (Monday)
 * Functionality : This class will show registration page for patient
 * Nevigation : move towards dashboard
 */

public class RegisterActivity extends ParentActivity implements View.OnClickListener {
    private final String TAG = "RegisterActivity";
    private EditText edtPatientID, edtUsername, edtPassword;
    private Button btnRegister;
    private TextView txtLoginNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUIControls();

        setUIData();

        registerForListener();


    }//end of onCreate()

    @Override
    void initUIControls() {
        super.initUIControls();
        edtPatientID = findViewById(R.id.edtPatientID);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtLoginNow = findViewById(R.id.txtLoginNow);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtLoginNow.setPaintFlags(txtLoginNow.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnRegister.setOnClickListener(this);
        txtLoginNow.setOnClickListener(this);
    }


    /******
     * This function will call to the api of registration and return the response.
     */
    private void callRegisterWebService() {

        WebServiceHelper webServiceHelper = new WebServiceHelper(this);
        String code_url = getResources().getString(R.string.CODE_URL);
        String API = "patient_registration.php";
        String POST_URL = code_url + API;

        HashMap<String, String> params = new HashMap<>();
        params.put("action", "patient_registration");
        params.put("patient_id", edtPatientID.getText().toString());
        params.put("mobile_number", edtUsername.getText().toString());
        params.put("password", edtPassword.getText().toString());


        webServiceHelper.callWS(POST_URL, params, new WebServiceHelper.JSONRequestHandlerPost() {

            @Override
            public void onSuccess(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject object = jsonObject.optJSONObject("header");

                    Log.d(TAG, "Status :: " + object.optString("status"));
                    Log.d(TAG, "message :: " + object.optString("message"));

                    switch (object.optString("status")) {
                        case "200":
                            JSONObject object1 = jsonObject.optJSONObject("data");

                            PreferenceData.setStringPreference(RegisterActivity.this, patient_id, object1.optString("patient_id"));
                            PreferenceData.setStringPreference(RegisterActivity.this, mobile_number, object1.optString("mobile_number"));
                            PreferenceData.setStringPreference(RegisterActivity.this, password, object1.optString("password"));


                            showToast(object1.optString("otp"));

                            Intent i = new Intent(RegisterActivity.this, VarificationActivity.class);
                            i.putExtra("patient_id", edtPatientID.getText().toString());
                            i.putExtra("mobile_number", edtUsername.getText().toString());
                            i.putExtra("password", edtPassword.getText().toString());
                            startActivity(i);
                            break;

                        case "704":
                            showToast(object.optString("message"));
                            break;

                        case "709":
                            showToast(object.optString("message"));
                            break;

                        case "780":
                            showToast(object.optString("message"));
                            break;
                        default:
                            showToast(object.optString("message"));

                            break;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
            }

            @Override
            public void networkNotAvailable(boolean isNetworkAvailable) {
                if (!isNetworkAvailable) {
                    Toast.makeText(RegisterActivity.this, "user network connection closed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(VolleyError error) {
                super.onFailure(error);
                error.printStackTrace();
            }
        });


    }//end of callRegisterWebService

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btnRegister:
                hideSoftKeyBoard(this);
                if (edtPatientID.getText().toString().isEmpty()) {

                    edtPatientID.setError("Patient ID required");

                } else if (edtUsername.getText().toString().isEmpty()) {

                    edtUsername.setError("Mobile number required");

                } else if (edtPassword.getText().toString().isEmpty()) {

                    edtPassword.setError("Password required");

                } else if (edtUsername.getText().toString().length() < 10) {

                    edtUsername.setError("Mobile number is less than 10 digits");

                } else {

                    callRegisterWebService();

                }
                break;

            case R.id.txtLoginNow:

                navigateToActivity(LoginActivity.class, false);
                break;

        }
    }
}//end of RegisterActivity
