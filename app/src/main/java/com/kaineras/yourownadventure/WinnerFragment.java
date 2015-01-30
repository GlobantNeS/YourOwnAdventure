package com.kaineras.yourownadventure;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WinnerFragment extends Fragment {

    View v;
    String winMes;
    String username;

    public WinnerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_winner, container, false);
        getPreferences();
        TextView winText=(TextView)v.findViewById(R.id.textView);
        winText.setText(username+" "+winMes);
        return v;
    }

    private void getPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        username=prefs.getString("username_preference", getString(R.string.default_username_string));
        winMes=prefs.getString("winner_message", getString(R.string.text_win));

    }


}
