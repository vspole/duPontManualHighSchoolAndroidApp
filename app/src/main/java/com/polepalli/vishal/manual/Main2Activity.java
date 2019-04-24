package com.polepalli.vishal.manual;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;


import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public FragmentManager fragmentManager = getFragmentManager();
    WebView myWebView;
    View myView;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        setHomePage();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" duPont Manual High School");
        toolbar.setLogo(R.drawable.shield  );
        setSupportActionBar(toolbar);
        DrawerLayout drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    public void setHomePage()
    {
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new Start())
                .commit();
    }



    @Override
    public boolean onCreateOptionsMenu(
            Menu menu) {
        return false;
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contact)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Contact())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.location)
        {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("google.navigation:q= 120 W Lee St, Louisville, KY 40208"));
            startActivity(intent);
        }
        else if (id == R.id.infiniteC)
        {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.infinitecampus.mobilePortal");
            if (launchIntent != null)
            {
                startActivity(launchIntent);
            } else
            {
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new InfiniteCampus())
                        .addToBackStack("Manual")
                        .commit();
            }
        }
        else if(id == R.id.Announcements)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Announcements())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if(id == R.id.library)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Library())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if(id == R.id.athletics)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Athletics())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if(id == R.id.shandbook)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new SHandBook())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.home)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new Start())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.social)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Social())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.calendar)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new JCalendar())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.staff)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Staff())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.counselor)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Counselors())
                    .addToBackStack("Manual")
                    .commit();
        }
        else if (id == R.id.PTSA)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PTSA())
                    .addToBackStack("Manual")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
