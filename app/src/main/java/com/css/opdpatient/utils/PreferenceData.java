package com.css.opdpatient.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jyoti on 19 Jan 2018 Friday
 * All preference data will be stored here
 */

public class PreferenceData {

    private static final String PREF_NAME = "opd_preference";
    private static final int PRIVATE_MODE = 0;
    public static final String USER_ID = "id";
    public static final String NAME = "name";

    public static final String mobile_Number = "mobile_number";
    public static final String first_Name = "first_name";
    public static final String last_Name = "last_name";
    public static final String date_of_birth = "birthdate";
    public static final String password = "password";
    public static final String Gender = "gender";

    public static final String patient_id = "patient_id";
    public static final String mobile_number = "mobile_number";
    public static final String Password = "password";
    public static final String OTP = "otp";


    public static final String isLogin = "is_login";

    /***
     * set string preference
     * @param context
     * @param keyName
     * @param keyValue
     */
    public static void setStringPreference(Context context, String keyName, String keyValue) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyName, keyValue);
        editor.apply();
    }//end of setStringPreference() for string

    /**
     * get preference by key
     *
     * @param context
     * @param keyName
     * @return
     */
    public static String getStringPreference(Context context, String keyName) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        return pref.getString(keyName, "");
    }//end of getStringPreference() for string values

    public static void setBooleanPreference(Context context, String keyName, boolean keyValue) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(keyName, keyValue);
        editor.apply();
    }//end of setStringPreference() for string

    /**
     * get preference by key
     *
     * @param context
     * @param keyName
     * @return
     */
    public static boolean getBooleanPreference(Context context, String keyName) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        return pref.getBoolean(keyName, false);
    }//end of getStringPreference() for string values

}   //end of PreferenceData
