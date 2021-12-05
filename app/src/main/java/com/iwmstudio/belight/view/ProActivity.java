package com.iwmstudio.belight.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.iwmstudio.belight.utils.PictureLayout;

public class ProActivity extends AppCompatActivity {
    // set to true to test Picture
    private static final boolean TEST_PICTURE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(View view) {
        if (TEST_PICTURE) {
            ViewGroup vg = new PictureLayout(this);
            vg.addView(view);
            view = vg;
        }

        super.setContentView(view);
    }
}