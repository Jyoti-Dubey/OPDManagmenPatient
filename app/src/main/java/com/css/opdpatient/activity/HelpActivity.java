package com.css.opdpatient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;

/**
 * Created By : Jyoti on 25 Jan 2018 (Saturday)
 * Functionality : This class will show login page for patient
 * Nevigation : move towards dashboard
 */
public class HelpActivity extends ParentActivity {

    private final String TAG = "HelpActivity";
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;

    private boolean scrollStarted, checkDirection;

    private ViewPager viewPager;
    private float thresholdOffset = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        initUIControls();

        setUIData();

        registerForListener();

        layouts = new int[]{
                R.layout.help_screen1,
                R.layout.help_screen2,
                R.layout.help_screen3,
                R.layout.help_screen4};

        // adding bottom dots
        addBottomDots(0);

        setViewPager();

    }//end of oncreate()

    private void setViewPager() {
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (checkDirection) {
                    if (thresholdOffset > positionOffset) {
                        Log.d(TAG, "going right " + position);
                        if (position == 3) {
                            navigateToActivity(RegisterActivity.class, true);
                        }
                    } else {
                        Log.d(TAG, "going left " + position);

                    }
                    checkDirection = false;
                }
            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (!scrollStarted && state == ViewPager.SCROLL_STATE_DRAGGING) {
                    scrollStarted = true;
                    checkDirection = true;
                } else {
                    scrollStarted = false;
                }

            }
        });

    }//end of setViewPager

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }//end of addBottomDots

    private void launchHomeScreen() {
        startActivity(new Intent(HelpActivity.this, LoginActivity.class));
        finish();
    }//end of launchHomeScreen


    void initUIControls() {
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);


    }//end of initUIControls

    void setUIData() {

    }//end of setUIData

    void registerForListener() {



        /*btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });*/

    }//end of registerForListener

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }//end of getItem


    private class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {

        }

        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }//end of instantiateItem

        @Override
        public int getCount() {
            return layouts.length;
        }//end of getCount

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }//end of isViewFromObject

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);

        }//end of destroyItem

    }//end of MyViewPagerAdapter
}
