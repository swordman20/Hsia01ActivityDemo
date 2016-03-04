package com.example.xwf.hsia01activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created:         Hsia on 16/3/3.
 * Email:           xiaweifeng@pingshow.net
 * Description:     {TODO}(用一句话描述该文件做什么)
 */
public class TwoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex", 0);
        TextView mName = (TextView) findViewById(R.id.tv_name);
        TextView mSex = (TextView) findViewById(R.id.tv_sex);
        mName.setText(name);
        switch (sex){
            case 1:
                mSex.setText("男");
                break;
            case 2:
                mSex.setText("女");
                break;
            case 3:
                mSex.setText("SB");
                break;
            default:
                mSex.setText("变态");
                break;
        }
    }
}
