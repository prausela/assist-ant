package com.assist.home.assisthome;

import android.app.ActionBar;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.assist.home.assisthome.api.API;

public abstract class AppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static Boolean notif;
    View nav_dev,nav_routines;
    private static Context mContext;
    RadioButton notifButton;
    DrawerLayout drawer;
    ActionBar actionBar;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        mContext = this;
        //notifButton=(RadioButton) findViewById(R.id.active_notifications);
//        if(notifButton.isChecked()==null || notifButton.isChecked()){
//            notif=true;
//        }
//        else {
//            notif=false;
//        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void checkForNotifications() {

    }
    public static Context getContext(){
        return mContext;
    }

    public static Boolean getNotif(){
        return notif;
    }

    public static void setNotif(Boolean n){
        API.getInstance().saveNotificationsSettings(n);
    }

    protected void setContent(@LayoutRes int content, String title){
        ViewStubCompat stub = (ViewStubCompat) findViewById(R.id.content);
        setTitle(title);
        stub.setLayoutResource(content);
        stub.inflate();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app, menu);
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
            Intent intent = new Intent(AppActivity.this,Settings.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dev && !this.getClass().equals(DeviceActivity.class)) {
            Intent intent = new Intent(AppActivity.this,DeviceActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
            startActivity(intent);
        } else if (id == R.id.nav_routines && !this.getClass().equals(RoutinesActivity.class)) {

            Intent intent = new Intent(AppActivity.this,RoutinesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
            startActivity(intent);

        }  else if (id == R.id.nav_manage && !this.getClass().equals(Settings.class)) {
            Intent intent = new Intent(AppActivity.this,Settings.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






}

