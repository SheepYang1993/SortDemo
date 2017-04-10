package me.sheepyang.sortdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;


/**
 * Created by SheepYang on 2017/4/10.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
