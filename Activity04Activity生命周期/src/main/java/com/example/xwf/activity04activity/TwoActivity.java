package com.example.xwf.activity04activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class TwoActivity extends AppCompatActivity {

    private static final String TAG = "Hsia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
//        Log.d(TAG,"onCreate");
    }
    public void start1(View v){
        startActivity(new Intent(this,MainActivity.class));
    }
    public void start2(View v){
        startActivity(new Intent(this,TwoActivity.class));
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart——activity被盖住了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume————Activity获得焦点");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause————Activity获得失去焦点");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
