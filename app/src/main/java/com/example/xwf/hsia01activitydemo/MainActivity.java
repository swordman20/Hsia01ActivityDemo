package com.example.xwf.hsia01activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private EditText mName;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.et_name);
        mRg = (RadioGroup) findViewById(R.id.rg);

    }

    public void onClick(View v) {
        String name = mName.getText().toString().trim();
        int checkedRadioButtonId = mRg.getCheckedRadioButtonId();
        int sex = 0;
        switch (checkedRadioButtonId){
            case R.id.rb_man:
                sex = 1;
                break;
            case R.id.rb_woman:
                sex = 2;
                break;
            case R.id.rb_other:
                sex = 3;
                break;
            default:
                sex = 0;
                break;
        }

        startActivity(new Intent().setData(Uri.parse("Hsia:")));

//        Intent intent = new Intent(MainActivity.this, TwoActivity.class);
//        intent.putExtra("name",name);
//        intent.putExtra("sex",sex);
//        startActivity(intent);
        //隐式意图
//        Intent intent = new Intent();
//        intent.setData(Uri.parse("Hsia:"));
//        intent.putExtra("name",name);
//        intent.putExtra("sex",sex);
//        startActivity(intent);
        //显式意图
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this,TwoActivity.class);
//        startActivity(intent);


        //隐式启动
//        startActivity(new Intent().setData(Uri.parse("Hsia:")));

        //显示意图
//        startActivity(new Intent(getApplicationContext(),TwoActivity.class));
    }
}
