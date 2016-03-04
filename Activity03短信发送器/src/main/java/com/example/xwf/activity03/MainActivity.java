package com.example.xwf.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mOpenConect;
    private Button mSend;
    private Button mTemp;
    private EditText mUsername;
    private EditText mDisc;
    public static final int setResultCode = 10;
    public static final int setrequestCode = 20;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenConect = (Button) findViewById(R.id.btn_openconect);
        mSend = (Button) findViewById(R.id.btn_send);
        mTemp = (Button) findViewById(R.id.btn_temp);

        mOpenConect.setOnClickListener(this);
        mTemp.setOnClickListener(this);
        mSend.setOnClickListener(this);
        mUsername = (EditText) findViewById(R.id.et_username);
        mDisc = (EditText) findViewById(R.id.et_disc);
        intent = new Intent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_openconect:
                intent.setClass(getApplicationContext(), ConectActivity.class);
                startActivityForResult(intent,setResultCode);
                Toast.makeText(getApplicationContext(),"进入联系人",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_temp:
                intent.setClass(getApplicationContext(), SMSTemp.class);
                startActivityForResult(intent,setrequestCode);
                break;
            case R.id.btn_send:
                String phoneNumer = mUsername.getText().toString().trim();
                String context = mDisc.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNumer)) {
                    Toast.makeText(getApplicationContext(),"请输入手机号码",Toast.LENGTH_SHORT).show();
                }else{
                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(phoneNumer, null, context, null, null);
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Hsia",resultCode+"resultCode");
        Log.d("Hsia",requestCode+"requestCode");
        if (resultCode==setResultCode){
            String phone = data.getStringExtra("phone");
            mUsername.setText(phone);
        }else if(requestCode==setrequestCode){
            String sms = data.getStringExtra("sms");
            mDisc.setText(sms);
        }
    }
}
