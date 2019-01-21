package com.example.silvia.tablayout;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private ViewPager viewPager;

    private FragmentHome homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    MenuItem prevMenuItem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.pager);
        mMainNav=findViewById(R.id.main_nav);


        homeFragment= new FragmentHome();
        notificationFragment= new NotificationFragment();
        accountFragment= new AccountFragment();

        //default fragment

        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);




        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:

                        // mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        // setFragment(homeFragment);
                        viewPager.setCurrentItem(0);
                        break;


                    case R.id.nav_notif:

                        // mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        // setFragment(notificationFragment);
                        viewPager.setCurrentItem(1);

                        break;


                    case R.id.nav_account:

                        // mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        // setFragment(accountFragment);
                        viewPager.setCurrentItem(2);

                        break;

                }

                return false;

            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    mMainNav.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                mMainNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mMainNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment=new FragmentHome();
        notificationFragment=new NotificationFragment();
        accountFragment=new AccountFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(notificationFragment);
        adapter.addFragment(accountFragment);
        viewPager.setAdapter(adapter);
    }



}
