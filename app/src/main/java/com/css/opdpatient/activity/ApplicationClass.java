package com.css.opdpatient.activity;

import android.app.Application;

import com.css.opdpatient.model.ApplicationModel;

import java.util.ArrayList;

/**
 * Created by jyoti on 10-02-2018.
 */

public class ApplicationClass extends Application {


    public ArrayList<ApplicationModel> arrayList = new ArrayList<ApplicationModel>();

    @Override
    public void onCreate() {
        super.onCreate();
        enterData();
    }

    public void enterData() {
        ApplicationModel applicationModel = new ApplicationModel();
        applicationModel.setName("Rupam Mishra");
        applicationModel.setRelation("Cousin");
        applicationModel.setId("2548");
        applicationModel.setDate("12 Jan,2018");

        arrayList.add(applicationModel);

        applicationModel = new ApplicationModel();
        applicationModel.setName("Rennu Dubey");
        applicationModel.setRelation("Sister-in-law");
        applicationModel.setId("5364");
        applicationModel.setDate("5 Jan,2018");
        arrayList.add(applicationModel);

        applicationModel = new ApplicationModel();
        applicationModel.setName("Raushni Dubey");
        applicationModel.setRelation("Sister");
        applicationModel.setId("2856");
        applicationModel.setDate("25 Feb,2018");
        arrayList.add(applicationModel);

        applicationModel = new ApplicationModel();
        applicationModel.setName("Sikha Singh");
        applicationModel.setRelation("Nephew");
        applicationModel.setId("8745");
        applicationModel.setDate("30 Feb,2018");
        arrayList.add(applicationModel);
    }
}
