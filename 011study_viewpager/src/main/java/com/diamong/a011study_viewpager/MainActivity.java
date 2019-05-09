package com.diamong.a011study_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    private Fragment[] fragments;
   // private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new Fragment[3];
        fragments[0] = new RedFragment();
        fragments[1] = new GreenFragment();
        fragments[2] = new BlueFragment();

        mPager = findViewById(R.id.viewpager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(pagerAdapter);
        //tabLayout = findViewById(R.id.tablayout);
        /*tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));*/


    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private Fragment[] arrFragment;

        public ScreenSlidePagerAdapter(FragmentManager fm, Fragment[] fragments) {
            super(fm);
            arrFragment = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return arrFragment[i];
        }

        @Override
        public int getCount() {
            return arrFragment.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RED";
                case 1:
                    return "GREEN";
                case 2:
                    return "BLUE";
                default:
                    return "";
            }

        }
    }
}
