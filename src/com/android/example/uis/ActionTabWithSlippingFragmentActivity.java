package com.android.example.uis;

import com.example.customview.MyActionBar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ActionTabWithSlippingFragmentActivity extends FragmentActivity
        implements ActionBar.TabListener {

    private ViewPager mViewPager;

    private ViewPagerAdapter mViewPagerAdapter;

    // replace tab
    private TextView [] button_tab_array;

    // tab image
    private Drawable bg_tab_selected;
    private Drawable bg_tab_normal;
    
    private MyActionBar myAb;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setUpActionBar();
        setUpViewPager();
        setUpTabs();
        
        getTab();
        //setUpMyBar();

    }

    

    /**
     * get the tab
     */
    private void getTab() {
        // TODO Auto-generated method stub
        myAb = (MyActionBar) findViewById(R.id.title_view);
        
    }



    private void setUpTabs() {
        final ActionBar actionBar = getActionBar();
        for (int i = 0; i < mViewPagerAdapter.getCount(); ++i) {
            actionBar.addTab(actionBar.newTab()
                    .setText(mViewPagerAdapter.getPageTitle(i))
                    .setTabListener(this));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }
    

    private void setUpActionBar() {
        final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
    }

    private void setUpViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager
                .setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        final ActionBar actionBar = getActionBar();
                        actionBar.setSelectedNavigationItem(position);
                        myAb.setCurrentTab(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        switch (state) {
                            case ViewPager.SCROLL_STATE_IDLE:
                                // TODO
                                break;
                            case ViewPager.SCROLL_STATE_DRAGGING:
                                // TODO
                                break;
                            case ViewPager.SCROLL_STATE_SETTLING:
                                // TODO
                                break;
                            default:
                                // TODO
                                break;
                        }
                    }
                });
    }

    
    /**
     * 安装自定义的Bar,暂时用view的方法实现
     */
    private void setUpMyBar() {
        // TODO Auto-generated method stub
        button_tab_array = new TextView[3];
        
        button_tab_array[0] = (TextView) findViewById(R.id.button_tab1);
        button_tab_array[1] = (TextView) findViewById(R.id.button_tab2);
        button_tab_array[2] = (TextView) findViewById(R.id.button_tab3);
        initTabButton();
    }

    private void initTabButton() {
        bg_tab_selected = getResources()
                .getDrawable(R.drawable.bg_tab_selected);
        bg_tab_normal = getResources().getDrawable(R.drawable.bg_tab_normal);
        seeTab1();

        // TODO Auto-generated method stub
        button_tab_array[0].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                seeTab1();
                System.out.println("点击了1");

            }

        });

        button_tab_array[1].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                seeTab2();
            }

        });

        button_tab_array[2].setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                seeTab3();
            }

        });
    }

    private void seeTab1() {
        // TODO Auto-generated method stub
        button_tab_array[0].setBackgroundResource(R.drawable.bg_tab_selected);
        button_tab_array[1].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[2].setBackgroundResource(R.drawable.bg_tab_normal);
        mViewPager.setCurrentItem(0);

    }

    private void seeTab2() {
        // TODO Auto-generated method stub
        button_tab_array[0].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[1].setBackgroundResource(R.drawable.bg_tab_selected);
        button_tab_array[2].setBackgroundResource(R.drawable.bg_tab_normal);
        mViewPager.setCurrentItem(1);

    }

    private void seeTab3() {
        // TODO Auto-generated method stub
        button_tab_array[0].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[1].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[2].setBackgroundResource(R.drawable.bg_tab_selected);
        mViewPager.setCurrentItem(2);

    }

}
