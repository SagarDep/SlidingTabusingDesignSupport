package com.androidbie.slidingtabsupportdesign;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidbie.slidingtabsupportdesign.adapters.SlidingTabAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SlidingTabAdapter slidingTabAdapter;

    //for the tab's items
    private TabLayout.Tab home;
    private TabLayout.Tab timeline;
    private TabLayout.Tab profile;

    //for get current item
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to hide the devider between action bar and tabLayout
        getSupportActionBar().setElevation(0);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        //initialize the adapter
        slidingTabAdapter = new SlidingTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidingTabAdapter);




        //set your tab's item
        home = tabLayout.newTab();
        timeline = tabLayout.newTab();
        profile = tabLayout.newTab();


        //labeling the tab's items
        home.setText("Home");
        timeline.setText("Timeline");
        profile.setText("Profile");


        //set the index of the tab's items
        tabLayout.addTab(home, 0);
        tabLayout.addTab(timeline,1);
        tabLayout.addTab(profile,2);

        //set tab selector color
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));

        //set the indicator
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorAccent));

        // switch the fragment when the current fragment was slided.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // switch the fragment when the tab item was clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //get current tab
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String position = sharedPreferences.getString("tab_opened", null);
        if(position==null){
            viewPager.setCurrentItem(1,true);
        }else if(position=="0"){
            viewPager.setCurrentItem(0,true);
        }else if(position=="1"){
            viewPager.setCurrentItem(1,true);
        }else if(position=="2"){
            viewPager.setCurrentItem(2,true);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tab_opened", "1");
        editor.commit();
    }

}
