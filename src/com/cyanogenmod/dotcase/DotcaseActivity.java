package com.cyanogenmod.dotcase;

import android.app.Activity;
import android.os.Bundle;

public class DotcaseActivity extends Activity
{
    private static final String TAG = "Dotcase";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final DrawView drawView = new DrawView(this);
        setContentView(drawView);
    }
}
