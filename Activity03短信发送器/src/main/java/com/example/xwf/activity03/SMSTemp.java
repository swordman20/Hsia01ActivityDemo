package com.example.xwf.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created:         Hsia on 16/3/4.
 * Email:           xiaweifeng@pingshow.net
 * Description:     {TODO}(用一句话描述该文件做什么)
 */
public class SMSTemp extends AppCompatActivity {

    private ListView mLsSms;
    String objects[] = {"丫头，生活是你自己的，你哭它就对你哭，你笑它就对你笑。转眼，又是一年，你的生日即将来到。今年，还是少不了我对你的祝福，我忍不住...",
            "世界上最动听的声音，是妈妈声声的呼唤；世界上最温暖的笑容，是妈妈温暖的笑脸。妈妈，原谅生日时我不能陪在您身边，在这个日子里，我...",
            "春天的鲜花，夏天的浪花，秋天的繁华，冬天的雪花，不论何时何地都希望你乐开花，朋友，在这阳光明媚的日子，我为你放飞一群祝福，祝你...",
            "我把春风织成一块温暖的毯子送给你，将幸福包住。我把春雨编成一条梦幻的丝带送给你，把快乐缠住。我把春天挂满祝福送给你，让美好留住...","丫头，生活是你自己的，你哭它就对你哭，你笑它就对你笑。转眼，又是一年，你的生日即将来到。今年，还是少不了我对你的祝福，我忍不住...",
            "世界上最动听的声音，是妈妈声声的呼唤；世界上最温暖的笑容，是妈妈温暖的笑脸。妈妈，原谅生日时我不能陪在您身边，在这个日子里，我...",
            "春天的鲜花，夏天的浪花，秋天的繁华，冬天的雪花，不论何时何地都希望你乐开花，朋友，在这阳光明媚的日子，我为你放飞一群祝福，祝你...",
            "我把春风织成一块温暖的毯子送给你，将幸福包住。我把春雨编成一条梦幻的丝带送给你，把快乐缠住。我把春天挂满祝福送给你，让美好留住..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        mLsSms = (ListView) findViewById(R.id.lv_sms);
        mLsSms.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.sms_item,objects));

        mLsSms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = objects[position];
                Intent intent = new Intent();
                intent.putExtra("sms",data);
                setResult(MainActivity.setrequestCode,intent);
                finish();
            }
        });
    }
}
