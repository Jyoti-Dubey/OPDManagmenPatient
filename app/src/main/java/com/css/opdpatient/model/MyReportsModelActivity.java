package com.css.opdpatient.model;

/**
 * Created by Jyoti on 02-02-2018.
 * This class will provide the data to recycler view of my reports
 */

public class MyReportsModelActivity {
    private final String TAG = "MyReportsModelActivity";

    private String txtMyReportsDate;
    private String txtMyReportsName;
    private String txtMyReportsDisease;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxtMyReportsDate() {
        return txtMyReportsDate;
    }

    public void setTxtMyReportsDate(String txtMyReportsDate) {
        this.txtMyReportsDate = txtMyReportsDate;
    }

    public String getTxtMyReportsName() {
        return txtMyReportsName;
    }

    public void setTxtMyReportsName(String txtMyReportsName) {
        this.txtMyReportsName = txtMyReportsName;
    }

    public String getTxtMyReportsDisease() {
        return txtMyReportsDisease;
    }

    public void setTxtMyReportsDisease(String txtMyReportsDisease) {
        this.txtMyReportsDisease = txtMyReportsDisease;
    }
}//end of BookToken2ModelActivity
