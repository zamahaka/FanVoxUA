package com.zamahaka.fanvoxua.ui.base.resultfix;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import com.zamahaka.fanvoxua.ui.base.callbacks.FragmentCallbackActivity;

import java.util.List;

/**
 * Created on 11.12.2015.
 * Provides workaround for nested fragment's activity execution for result issue
 * NOTE:child fragments must be inherited from corresponding {@link ActivityResultFixFragment}
 */
public class ActivityResultFixActivity extends FragmentCallbackActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager manager = getSupportFragmentManager();
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    public void replaceFragment(Fragment fragment, int containerId, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment, tag)
                .commit();
    }

    public void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}
