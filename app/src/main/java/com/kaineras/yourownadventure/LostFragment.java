package com.kaineras.yourownadventure;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LostFragment extends Fragment {

    View v;
    String lostMes;
    String username;

    public LostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_lost, container, false);
        getPreferences();
        TextView lostText=(TextView)v.findViewById(R.id.textView2);
        lostText.setText(username+" "+lostMes);
        return v;
    }

    private void getPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        username=prefs.getString("username_preference", getString(R.string.default_username_string));
        lostMes=prefs.getString("looser_message", getString(R.string.text_lost));

    }

}
