package com.kaineras.yourownadventure;


import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends ActionBarActivity {

    Tools t=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        t=new Tools();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t.loadFragment(getFragmentManager(),new StartFragment(),R.id.container,"START");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (getFragmentManager().getBackStackEntryCount() == 1)
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

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment currentFrag =  getFragmentManager().findFragmentById(R.id.container);

        if (currentFrag!=null)
            transaction.remove(currentFrag);
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