package com.kaineras.yourownadventure;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import java.util.Random;

/**
 * Created the first version by kaineras on 30/01/15.
 */
public class Tools {
    public Tools()
    {

    }

    public void loadFragment(FragmentManager fm,Fragment f,int container,String namestack)
    {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(namestack);
        fragmentTransaction.replace(container, f);
        fragmentTransaction.commit();
    }

    public boolean isLost(int dice,int dif)
    {
        boolean result=false;
        if(dice-(dif*2)<10)
            result=true;
        return  result;
    }

    public boolean isWin(int dice,int dif)
    {
        boolean result=false;
        if(dice-(dif*2)>10)
            result=true;
        return  result;
    }

    public int rollDice()
    {
        int result;
        Random r = new Random();
        result = r.nextInt(20);
        return  (result);
    }
}
