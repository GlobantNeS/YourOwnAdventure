package com.kaineras.yourownadventure;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class MainActivity extends ActionBarActivity {


    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadStartFragment();
    }

    private void loadStartFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new StartFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);
        transaction.addToBackStack("Start");
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (getFragmentManager().getBackStackEntryCount() == 0)
            {
                this.finish();
                return false;
            }
            else
            {
                getFragmentManager().popBackStack();
                removeCurrentFragment();

                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void removeCurrentFragment()
    {
        String fragName = "NONE";

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment currentFrag =  getFragmentManager().findFragmentById(R.id.container);

        if (currentFrag!=null) {
            fragName = currentFrag.getClass().getSimpleName();
            transaction.remove(currentFrag);
        }

        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}