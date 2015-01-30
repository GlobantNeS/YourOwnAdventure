package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created the first version by kaineras on 23/01/15.
 */
public class StartFragment extends Fragment {

    ImageButton mButtonStart=null;
    View view;
    Tools t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_start, container, false);
        preparedButton();
        return view;
    }
    private void preparedButton() {
        t=new Tools();
        mButtonStart=(ImageButton)view.findViewById(R.id.buttonStart);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.rollDice() % 2 == 0)
                    t.loadFragment(getFragmentManager(),new AlleyFragment(),R.id.container,"ALLEY");
                else
                    t.loadFragment(getFragmentManager(), new RoomFragment(), R.id.container, "ROOM");
            }
        });
    }
}
