package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class AlleyFragment extends Fragment {

    ImageButton mButtonLeft = null;
    ImageButton mButtonUp = null;
    ImageButton mButtonRight = null;
    View view;
    Tools t = null;
    String username;
    String diff;

    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        t = new Tools();
        view = inflater.inflate(R.layout.fragment_alley, container, false);
        mButtonUp = (ImageButton) view.findViewById(R.id.buttonUp);
        mButtonLeft = (ImageButton) view.findViewById(R.id.buttonLeft);
        mButtonRight = (ImageButton) view.findViewById(R.id.buttonRight);
        getPreferences();
        listenerUp();
        listenerLeft();
        listenerRight();
        return view;
    }

    private void getPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        username=prefs.getString("username_preference", getString(R.string.default_username_string));
        diff=prefs.getString("user_difficulty", getString(R.string.default_difficult_string));
    }

    private void listenerRight() {
        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t.rollDice() % 2 == 0)
                    t.loadFragment(getFragmentManager(), new RoomFragment(), R.id.container, "ROOM");
                }
        });
    }

    private void listenerLeft() {
        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t.isLost(t.rollDice(),diff))
                    t.loadFragment(getFragmentManager(), new LostFragment(), R.id.container, "LOST");
                else if (t.rollDice() % 2 == 0)
                    t.loadFragment(getFragmentManager(), new RoomFragment(), R.id.container, "ROOM");
            }
        });
    }

    private void listenerUp() {
        mButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t.isWin(t.rollDice(), diff))
                    t.loadFragment(getFragmentManager(), new WinnerFragment(), R.id.container, "WIN");
                else
                    if (t.rollDice() % 2 == 0)
                        t.loadFragment(getFragmentManager(), new RoomFragment(), R.id.container, "ROOM");

            }
        });
    }
}