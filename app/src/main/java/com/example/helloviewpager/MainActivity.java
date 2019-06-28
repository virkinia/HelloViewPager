package com.example.helloviewpager;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements listenerOnClickHint {
    MyPagerAdapter adapterViewPager;
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }


    @Override
    public void onFragmentInteraction(int value) {

        vpPager.setCurrentItem(value);

    }

    //Recibimos los eventos de los Fragments
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return RedFragment.newInstance("", "");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return BlueFragment.newInstance("", "");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return PinkFragment.newInstance("", "");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RED";
                case 1:
                    return "BLUE";
                case 2:
                    return "PINK";
                default:
                    return "TAB";
            }
        }
    }
}
