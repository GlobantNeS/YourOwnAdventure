package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created the first version by kaineras on 23/01/15.
 */
public class StartFragment extends Fragment {

    ImageButton mButtonStart=null;
    View view;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_start, container, false);
        preparedButton();
        return view;
    }
    private void preparedButton() {
        mButtonStart=(ImageButton)view.findViewById(R.id.buttonStart);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int ran = r.nextInt(10);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                if(ran%2==0) {
                    loadFragment(new AlleyFragment());
                }
                else
                {
                    loadFragment(new RoomFragment());
                }
            }

            private void loadFragment(Fragment f) {
                fragmentTransaction.addToBackStack(f.getClass().getSimpleName());
                fragmentTransaction.replace(R.id.container, f);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        });
    }
}
