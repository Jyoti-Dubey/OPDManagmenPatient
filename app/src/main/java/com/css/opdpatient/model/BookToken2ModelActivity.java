package com.css.opdpatient.model;

/**
 * Created by Jyoti on 01-02-2018.
 * This class will provide the data to recycler view of booked token2
 */

public class BookToken2ModelActivity {
    private final String TAG = "BookToken2ModelActivity";

    private String imgRecyclerBookToken2;
    private String txtRecyclerBookToken2Name;
    private String txtRecyclerBookToken2Relation;

    public BookToken2ModelActivity(String txtRecyclerBookToken2Name, String txtRecyclerBookToken2Relation) {
        this.setTxtRecyclerBookToken2Name(txtRecyclerBookToken2Name);
        this.setTxtRecyclerBookToken2Relation(txtRecyclerBookToken2Relation);
    }

    public String getImgRecyclerBookToken2() {
        return imgRecyclerBookToken2;
    }

    public void setImgRecyclerBookToken2(String imgRecyclerBookToken2) {
        this.imgRecyclerBookToken2 = imgRecyclerBookToken2;
    }

    public String getTxtRecyclerBookToken2Name() {
        return txtRecyclerBookToken2Name;
    }

    public void setTxtRecyclerBookToken2Name(String txtRecyclerBookToken2Name) {
        this.txtRecyclerBookToken2Name = txtRecyclerBookToken2Name;
    }

    public String getTxtRecyclerBookToken2Relation() {
        return txtRecyclerBookToken2Relation;
    }

    public void setTxtRecyclerBookToken2Relation(String txtRecyclerBookToken2Relation) {
        this.txtRecyclerBookToken2Relation = txtRecyclerBookToken2Relation;
    }
}//end of BookToken2ModelActivity
