package com.kaineras.yourownadventure;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created the first version by kaineras on 30/01/15.
 */
public class AppSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
