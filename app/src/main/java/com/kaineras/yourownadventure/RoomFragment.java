package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class RoomFragment extends Fragment {

    ImageButton mButtonLeft=null;
    ImageButton mButtonRight=null;
    View view;
    Tools t=null;
    String diff;

    public RoomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        t=new Tools();
        view =inflater.inflate(R.layout.fragment_room, container, false);
        mButtonLeft=(ImageButton) view.findViewById(R.id.buttonDoor1);
        mButtonRight=(ImageButton) view.findViewById(R.id.buttonDoor2);
        getPreferences();
        listenerLeft();
        listenerRight();
        return view;

    }

    private void getPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        diff=prefs.getString("user_difficulty", getString(R.string.default_difficult_string));
    }


    private void listenerLeft() {
        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.isLost(t.rollDice(),diff))
                    t.loadFragment(getFragmentManager(),new LostFragment(),R.id.container,"LOST");
                else
                    if(t.rollDice()%2==0)
                        t.loadFragment(getFragmentManager(),new AlleyFragment(),R.id.container,"ALLEY");
                    else
                        t.loadFragment(getFragmentManager(),new RoomFragment(),R.id.container,"ROOM");
            }
        });
    }

    private void listenerRight() {
        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.isWin(t.rollDice(),diff))
                    t.loadFragment(getFragmentManager(), new WinnerFragment(), R.id.container, "WIN");
                else
                    if(t.rollDice()%2==0)
                        t.loadFragment(getFragmentManager(),new AlleyFragment(),R.id.container,"ALLEY");
                    else
                        t.loadFragment(getFragmentManager(),new RoomFragment(),R.id.container,"ROOM");
            }
        });
    }
}
