/**
 * @(#)ViewPagerAdapter.java, 2014年7月4日. 
 * 
 * Copyright 2014 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.android.example.uis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 *
 * @author Administrator
 *
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    
    private Fragment1 mFragment1 = new Fragment1();

    private Fragment2 mFragment2 = new Fragment2();

    private Fragment3 mFragment3 = new Fragment3();

    private static final int TAB_INDEX_COUNT = 3;

    private static final int TAB_INDEX_ONE = 0;

    private static final int TAB_INDEX_TWO = 1;

    private static final int TAB_INDEX_THREE = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        switch (position) {
            case TAB_INDEX_ONE:
                return mFragment1;
            case TAB_INDEX_TWO:
                return mFragment2;
            case TAB_INDEX_THREE:
                return mFragment3;
        }
        throw new IllegalStateException("No fragment at position "
                + position);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TAB_INDEX_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String tabLabel = null;
        switch (position) {
            case TAB_INDEX_ONE:
                tabLabel = "R";
                break;
            case TAB_INDEX_TWO:
                tabLabel = "G";
                break;
            case TAB_INDEX_THREE:
                tabLabel = "B";
                break;
        }
        return tabLabel;
    }
}
