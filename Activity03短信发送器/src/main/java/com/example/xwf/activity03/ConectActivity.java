package com.example.xwf.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created:         Hsia on 16/3/4.
 * Email:           xiaweifeng@pingshow.net
 * Description:     {TODO}(用一句话描述该文件做什么)
 */
public class ConectActivity extends AppCompatActivity {

    private ListView mLv;
    private HashMap<String,String> hashMap;
    private ConectBean cb;
    private String name;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conect);
        final List<ConectBean> list = new ArrayList<>();

        for (int i = 0;i<7;i++){
            cb = new ConectBean();
            cb.setName("zhangsan" + i);
            cb.setNumber("1355555" + i);
            list.add(cb);
        }
        mLv = (ListView) findViewById(R.id.lv);
//        mLv.setAdapter(new ArrayAdapter<Map<String,String>>(this,R.layout.content_item, objects));
        mLv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = null;
                ConectBean conectBean = list.get(position);
                if (convertView==null){
                    view =  View.inflate(getApplicationContext(), R.layout.content_item, null);
                }else{
                    view = convertView;
                }
                TextView tvUsername = (TextView) view.findViewById(R.id.tv_username);
                TextView tvNumber = (TextView) view.findViewById(R.id.tv_number);
                name = conectBean.getName();
                tvUsername.setText(name);
                number = conectBean.getNumber();
                tvNumber.setText(number);
                return view;
            }
        });

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),name+number,position).show();
                Intent intent = new Intent();
                ConectBean conectBean = list.get(position);
                intent.putExtra("phone", conectBean.getNumber());
                setResult(MainActivity.setResultCode, intent);
                finish();
            }
        });
    }
}
