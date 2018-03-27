package com.css.opdpatient.model;

/**
 * Created by Jyoti on 05-02-2018.
 * This class will provide the data to recycler view of  reports detail
 */

public class ReportsDetailModel {
    private final String TAG = "ReportsDetailModel";

    private String testName;
    private String labName;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    private int imageCount;


    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    private String image3;
    private String btnReportsDetail;


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}//end of BookToken2ModelActivity
