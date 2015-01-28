package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.Random;


public class AlleyFragment extends Fragment{

    ImageButton mButtonLeft=null;
    ImageButton mButtonUp=null;
    ImageButton mButtonRight=null;
    View view;
    FragmentTransaction fragmentTransaction;

    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_alley, container, false);
        mButtonUp=(ImageButton) view.findViewById(R.id.buttonUp);
        mButtonLeft=(ImageButton) view.findViewById(R.id.buttonLeft);
        mButtonRight=(ImageButton) view.findViewById(R.id.buttonRight);
        listenerUp();
        listenerLeft();
        listenerRight();
        return view;
    }

    private void listenerRight() {
        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Random r = new Random();
                int ran = r.nextInt(10);
                if (ran % 2 == 0) {
                    RoomFragment fragment = new RoomFragment();
                    fragmentTransaction.addToBackStack("Room");
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    private void listenerLeft() {
        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Random r = new Random();
                int lost = r.nextInt(10);
                if(lost==6)
                {
                    LostFragment fragment = new LostFragment();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();
                }
                else
                {
                    int ran = r.nextInt(10);
                    if(ran%2==0) {
                        RoomFragment fragment = new RoomFragment();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                    }
                }

            }
        });
    }

    private void listenerUp() {
        mButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Random r = new Random();
                int win = r.nextInt(10);
                if(win==7)
                {
                    WinnerFragment fragment = new WinnerFragment();
                    fragmentTransaction.addToBackStack("Win");
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();
                }
                else
                {
                    int ran = r.nextInt(10);
                    if(ran%2==0) {
                        RoomFragment fragment = new RoomFragment();
                        fragmentTransaction.addToBackStack("Room");
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                    }
                }

            }
        });
    }
}