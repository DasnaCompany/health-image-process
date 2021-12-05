package com.iwmstudio.belight.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class IranSansTextView extends AppCompatTextView {

    public IranSansTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "iransans.ttf"));
    }
}