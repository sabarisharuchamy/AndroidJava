package com.appin.javaexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ShareDataBetweenFragments extends AppCompatActivity implements FragmentOne.SendMessage{
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data_between_fragments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new FragmentOne();
            } else if (position == 1) {
                fragment = new FragmentTwo();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0) {
                title = "Tab-1";
            } else if (position == 1) {
                title = "Tab-2";
            }
            return title;
        }
    }

}