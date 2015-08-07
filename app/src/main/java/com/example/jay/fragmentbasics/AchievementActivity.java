package com.example.jay.fragmentbasics;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;

import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
import android.widget.AdapterView;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.app.Activity;

public class AchievementActivity extends Activity {
    //This is a string array for listview, and those should be dynamically loaded when you start implementing
    private String[] myAchievement = {"Uplevel to LV5!", "LV10", "Help 10 people", "Help 100 people"};
    //This is an img src array for listview
    private int[] myAchievementImg = {R.drawable.star_icon, R.drawable.lock_icon, R.drawable.lock_icon, R.drawable.lock_icon};

    //This is the adapter
    private AchievementAdapter listAdapter;
    //My Achievement ListView
    private ListView achievementListView;
    Context context;


    private void customActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.argb(255, 255, 255, 255)));
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);

        LayoutParams layout = new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT);
        ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_achievement_actionbar, null);
        actionBar.setCustomView(actionBarLayout, layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Log.d("Jean","actionbar start");
//        //set actionbar
//        customActionBar();
//        Log.d("Jean", "actionbar done");

        setContentView(R.layout.activity_achievement);

        context=this;

        achievementListView = (ListView) findViewById(R.id.listAchievement);
        listAdapter = new AchievementAdapter(this, myAchievement, myAchievementImg);
        achievementListView.setAdapter(listAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_achievement, menu);
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
