package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.css.opdpatient.R;
import com.css.opdpatient.utils.PreferenceData;
import com.css.opdpatient.webservice.WebServiceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.css.opdpatient.utils.PreferenceData.patient_id;

/***
 * Created By : Jyoti on 20 Feb 2018 (Tuesday)
 * Functionality : This will varify the OTP for the mobile number
 */
public class VarificationActivity extends ParentActivity {
    private String TAG = "VarificationActivity";

    private Button btnVarification;
    private EditText edtVarify1, edtVarify2, edtVarify3, edtVarify4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification);

        initUIControls();

        registerForListener();
    }

    @Override
    void initUIControls() {
        super.initUIControls();
        btnVarification = findViewById(R.id.btnVarification);
        edtVarify1 = findViewById(R.id.edtVarify1);
        edtVarify2 = findViewById(R.id.edtVarify2);
        edtVarify3 = findViewById(R.id.edtVarify3);
        edtVarify4 = findViewById(R.id.edtVarify4);

    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnVarification.setOnClickListener(this);
    }

    /******
     * This function will call to the api of otp verification and return the response.
     */

    private void callOTPWebService() {
        WebServiceHelper webServiceHelper = new WebServiceHelper(this);
        String code_url = getResources().getString(R.string.CODE_URL);
        String API = "verify_otp.php";
        String POST_URL = code_url + API;

        HashMap<String, String> params = new HashMap<>();
        params.put("action", "verify_otp");
        params.put("patient_id", "1");
        params.put("mobile_number", "9898552949");
        params.put("password", "12345a");
        params.put("otp", edtVarify1.getText().toString() + edtVarify2.getText().toString() + edtVarify3.getText().toString() +
                edtVarify4.getText().toString());
        //Toast.makeText(VarificationActivity.this, "OTP", Toast.LENGTH_LONG).show();


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

                            JSONArray jsonArray = jsonObject.optJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object1 = jsonArray.optJSONObject(i);
                                PreferenceData.setStringPreference(VarificationActivity.this, patient_id, object1.optString("patient_id"));

                            }
                            Intent i = new Intent(VarificationActivity.this, DashboardActivity.class);
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
                    Toast.makeText(VarificationActivity.this, "user network connection closed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(VolleyError error) {
                super.onFailure(error);
                error.printStackTrace();
            }
        });
    }//end of callOTPWebService


    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btnVarification:
                callOTPWebService();
                // Toast.makeText(VarificationActivity.this, "OTP:" + OTP, Toast.LENGTH_LONG).show();
                //  navigateToActivity(DashboardActivity.class, false);
                break;
        }
    }
}
