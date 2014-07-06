/**
 * @(#)MyActionBar.java, 2014年7月4日. 
 * 
 * Copyright 2014 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.customview;


import com.android.example.uis.R;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 *
 * @author Jiyuan
 *
 */
public class MyActionBar extends FrameLayout {
    
    // replace tab
    private TextView [] button_tab_array;

    // tab image
    private Drawable bg_tab_selected;
    private Drawable bg_tab_normal;
    
    private int tabNum = 3;
    private boolean [] tab_status={true,false,false};
    
    public MyActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_ab, this);
        
        setUpMyBar();

    }
    
    public MyActionBar getMyActionBar(){
        
        return this;    
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
        tab_status[0]=true;
        tab_status[1]=false;
        tab_status[2]=false;
    }

    private void seeTab2() {
        // TODO Auto-generated method stub
        button_tab_array[0].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[1].setBackgroundResource(R.drawable.bg_tab_selected);
        button_tab_array[2].setBackgroundResource(R.drawable.bg_tab_normal);
        tab_status[0]=false;
        tab_status[1]=true;
        tab_status[2]=false;
    }

    private void seeTab3() {
        // TODO Auto-generated method stub
        button_tab_array[0].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[1].setBackgroundResource(R.drawable.bg_tab_normal);
        button_tab_array[2].setBackgroundResource(R.drawable.bg_tab_selected);
        tab_status[0]=false;
        tab_status[1]=false;
        tab_status[2]=true;
    }
    
    public void setCurrentTab(int position) {
        if (position >= tabNum) {
            //
        }
        for (int i = 0; i < tabNum; i++) {
            if (i == position)
                button_tab_array[i]
                        .setBackgroundResource(R.drawable.bg_tab_selected);
            else
                button_tab_array[i]
                        .setBackgroundResource(R.drawable.bg_tab_normal);
        }
   }
    
    public int onTabSelected() {

        for (int i = 0; i < tabNum; i++) {
            if (tab_status[i])
                return i;
        }
        return 0;
    }


}
