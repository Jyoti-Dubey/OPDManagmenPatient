package com.css.opdpatient.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.css.opdpatient.R;
import com.css.opdpatient.utils.PreferenceData;
import com.css.opdpatient.webservice.WebServiceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.css.opdpatient.utils.PreferenceData.NAME;
import static com.css.opdpatient.utils.PreferenceData.USER_ID;
import static com.css.opdpatient.utils.PreferenceData.isLogin;
import static com.css.opdpatient.utils.PreferenceData.mobile_Number;

/**
 * Created By : Jyoti on 20 Jan 2018 (Saturday)
 * Functionality : This class will show login page for patient
 * Nevigation : move towards dashboard
 */
public class LoginActivity extends ParentActivity {

    private final String TAG = "LoginActivity";
    private TextView txtForgotPassword;
    private TextView txtRegisterNow;
    private Button btnPatientLogin;
    private EditText edtPatientUsername;
    private EditText edtPatientPassword;

    private ProgressBar progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUIControls();

        registerForListener();

        setUIData();


    }//end of onCreate()


    void initUIControls() {
        txtRegisterNow = findViewById(R.id.txtRegisterNow);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        btnPatientLogin = findViewById(R.id.btnPatientLogin);
        edtPatientUsername = findViewById(R.id.edtPatientUsername);
        edtPatientPassword = findViewById(R.id.edtPatientPassword);
        progressLogin = findViewById(R.id.progressLogin);

    }//end of initUIControls

    @Override
    void setUIData() {
        txtForgotPassword.setPaintFlags(txtForgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtRegisterNow.setPaintFlags(txtRegisterNow.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    void registerForListener() {
        btnPatientLogin.setOnClickListener(this);

        txtRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtForgotPassword.setOnClickListener(this);

    }//end ofregisterForListener

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPatientLogin:
                hideSoftKeyBoard(this);
                if (edtPatientUsername.getText().toString().isEmpty()) {

                    edtPatientUsername.setError("Mobile number required");

                } else if (edtPatientPassword.getText().toString().isEmpty()) {

                    edtPatientPassword.setError("Password required");

                } else if (edtPatientUsername.getText().toString().length() < 10) {

                    edtPatientUsername.setError("Mobile number is less than 10 digits");

                } else {
                    progressLogin.setVisibility(View.VISIBLE);
                    callLoginWebService();
                    //navigateToActivity(DashboardActivity.class, false);
                }
                break;

            case R.id.txtForgotPassword:
                navigateToActivity(ForgotPasswordActivity.class, false);
                break;
        }
    }

    /******
     * This function will call to the api of login and return the response.
     */
    private void callLoginWebService() {

        WebServiceHelper webServiceHelper = new WebServiceHelper(this);
        String code_url = getResources().getString(R.string.CODE_URL);
        String API = "get_login_patients.php";
        String POST_URL = code_url + API;

        HashMap<String, String> params = new HashMap<>();
        params.put("action", "login");
        params.put("patient_id", "1");
        //  params.put("patient_id", edtPatientUsername.getText().toString());
        // params.put("mobile_number","9898552949");
        params.put("password", "12345a");

        webServiceHelper.callWS(POST_URL, params, new WebServiceHelper.JSONRequestHandlerPost() {
            @Override
            public void onSuccess(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject object = jsonObject.optJSONObject("header");


                    switch (object.optString("status")) {
                        case "200":

                            JSONArray jsonArray = jsonObject.optJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object1 = jsonArray.optJSONObject(i);

                                PreferenceData.setStringPreference(LoginActivity.this, USER_ID, object1.optString("id"));
                                PreferenceData.setStringPreference(LoginActivity.this, NAME, object1.optString("name"));
                                PreferenceData.setStringPreference(LoginActivity.this, mobile_Number, object1.optString("mobile_number"));
                                PreferenceData.setBooleanPreference(LoginActivity.this, isLogin, true);


                            }
                           /* Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                            i.putExtra("patient_id", "patient_id");
                            i.putExtra("username", edtPatientUsername.getText().toString());
                            i.putExtra("PASSWORD", edtPatientPassword.getText().toString());
                            startActivity(i);*/
                            navigateToActivity(DashboardActivity.class, true);
                            break;

                        case "704":
                            showToast(object.optString("message"));
                            break;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    progressLogin.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(VolleyError error) {
                error.printStackTrace();
            }

            @Override
            public void networkNotAvailable(boolean isNetworkAvailable) {
                if (!isNetworkAvailable) {
                    Toast.makeText(LoginActivity.this, "user network connection closed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}//end of LoginActivity
