package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("x1aolata"); // 调用父类的有参构造函数
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // 打印当前线程的id
        Log.d("x1aolata", "子线程：Thread id is " + Thread.currentThread(). getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("x1aolata", "onDestroy executed");
    }
}
