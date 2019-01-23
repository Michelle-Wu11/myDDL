package com.example.wuyunan.myddl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThreadInit();
    }
    /*

    //线程运行2s后跳转到另外一个视图

     */
    private void ThreadInit () {
        Runnable mRunnable=new Runnable() {
            @Override
            public void run () {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Intent mIntent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(mIntent);
            }
        };
        Thread mThread=new Thread(mRunnable);
        mThread.start();
    }
}
