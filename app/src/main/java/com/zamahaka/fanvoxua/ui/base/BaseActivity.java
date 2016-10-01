package com.zamahaka.fanvoxua.ui.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zamahaka.fanvoxua.R;
import com.zamahaka.fanvoxua.ui.base.resultfix.ActivityResultFixActivity;

public class BaseActivity extends ActivityResultFixActivity {
    private Toolbar mToolbar;

    @Override
    public void setContentView(int layoutResId) {
        setContentView(layoutResId, true);
    }

    public void setContentView(int layoutResID, boolean hasToolbar) {
        if (hasToolbar) {
            super.setContentView(R.layout.activity_base_with_toolbar);
            mToolbar = (Toolbar) findViewById(R.id.toolbar_base);
            setSupportActionBar(mToolbar);
        } else {
            super.setContentView(R.layout.activity_base_without_toolbar);
        }

        ViewGroup rootView = (ViewGroup) findViewById(R.id.root_view);
        LayoutInflater.from(this).inflate(layoutResID, rootView, true);
    }
}
