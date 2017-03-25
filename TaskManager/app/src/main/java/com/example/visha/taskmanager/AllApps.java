package com.example.visha.taskmanager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import java.util.List;

/**
 * Created by visha on 3/24/2017.
 */

public class AllApps extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        setContentView(R.layout.all_apps);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

        for (int i = 0; i < recentTasks.size(); i++)
        {
            Log.d("Executed app", "Application executed : " +recentTasks.get(i).baseActivity.toShortString()+ "\t\t ID: "+recentTasks.get(i).id+"");
        }
//        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
//        am.getMemoryInfo(info);
//        System.out.println(info);
//        ActivityManager.RecentTaskInfo task = am.getRecentTasks(1, 0).get(0);
//        startActivity(task.baseIntent);
    }
}
