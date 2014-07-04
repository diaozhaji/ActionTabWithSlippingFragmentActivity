/**
 * @(#)MyActionBar.java, 2014年7月4日. 
 * 
 * Copyright 2014 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.customview;


import com.android.example.uis.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 *
 * @author Jiyuan
 *
 */
public class MyActionBar extends FrameLayout{
    private Button leftButton;

    private TextView titleText;
    
    public MyActionBar(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_ab, this);
        titleText = (TextView) findViewById(R.id.title_text);
        leftButton = (Button) findViewById(R.id.button_left);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        
    }
    public void setTitleText(String text) {
        titleText.setText(text);
    }

    public void setLeftButtonText(String text) {
        leftButton.setText(text);
    }

    public void setLeftButtonListener(OnClickListener l) {
        leftButton.setOnClickListener(l);
    }
    
    
}
