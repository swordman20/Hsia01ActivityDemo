#Android学习从零单排之Activity


**读了那么多年的书让我明白一个道理。人要稳重，不要想到啥就做啥。做一行越久即使你不会，几年之后慢慢的你也会了，加上一点努力你或许你能成为别人眼中的专家。**

##Activity配置多个启动的图标
如果你想让你的应用程序可以有多个启动入口

```
<intent-filter>
	<action android:name="android.intent.action.MAIN" />
	<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>

```

##隐式意图和显式意图
**区别**

隐式意图需要在清单文件配置显示意图不需要在清单文件中配置。

```
 <activity android:name=".TwoActivity">
            <intent-filter>
                <!--必须配置-->
                <action android:name="Hsia" />
                <category android:name="android.intent.category.DEFAULT" />
                <!--可以不配置-->
                <category android:name="Hsia" />
                <!-- 必须配置-->
                <data android:scheme="Hsia"/>
            </intent-filter>
        </activity>
```
隐式意图一般用来启动别人app的界面（需要知道activity的action，data，category），显式意图是用来启动自己工程下的界面

**写法**

常规写法

```
 //隐式意图
//        Intent intent = new Intent();
//        intent.setAction("Hsia");
//        intent.setData(Uri.parse("Hsia:"));
//        intent.addCategory("Hsia");
//        startActivity(intent);
        //显式意图
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,TwoActivity.class);
        startActivity(intent);
```

链式写法

```
 		 //隐式启动（我只需要知道activity的data就可以直接启动）
//        startActivity(new Intent().setData(Uri.parse("Hsia:")));

        //显示意图
//        startActivity(new Intent(getApplicationContext(),TwoActivity.class));

```

##意图传递数据 
**intent可以传递java八大基本数据类型**
intent发送数据key全为String

```
Intent intent = new Intent(MainActivity.this, TwoActivity.class);
//        intent.putExtra("name",name);
//        intent.putExtra("sex",sex);
//        startActivity(intent);
```
intent接受数据

```
		Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex", 0);
        
```

##onActivityResult获取返回值结果
**步骤**

```
	 	1、在开启activity时调用
	      //开启一个activity并等待返回结果
		  startActivityForResult(intent, 200);
	   2、在目标activity中设置返回的数据
		  Intent intent = new Intent();
			intent.putExtra("username", username);
			//设置界面关闭时返回数据
			setResult(200, intent);
	   3、关闭目标activity
			//自动关闭界面
			finish();
	   4、在原Activity重写onActivityResult方法接收返回的数据：
```
**代码**

```
一、MainActivity：
	intent.setClass(getApplicationContext(), ConectActivity.class);
                startActivityForResult(intent,setResultCode);
                Toast.makeText(getApplicationContext(),"进入联系				人",Toast.LENGTH_SHORT).show();
                break;
二、ConectActivity：
	Intent intent = new Intent();
                ConectBean conectBean = list.get(position);
                intent.putExtra("phone", conectBean.getNumber());
                setResult(MainActivity.setResultCode, intent);
                finish();
三、Mainactivity：
		/**
		 * requestCode 开启activity时设置的请求吗
		 * resultCode 在目标activity中设置的结果码
		 * data 第二个界面返回的数据
		 */
	 @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==setResultCode){
            String phone = data.getStringExtra("phone");
            mUsername.setText(phone);
        }else if(requestCode==setrequestCode){
            String sms = data.getStringExtra("sms");
            mDisc.setText(sms);
        }
    }

```

##Activity的生命周期

```
	 onCreate：在activity被创建的时候调用这个方法，初始化界面；
	 onStart：当界面可见的时候调用；
     onResume 按钮可以被点击的时候；     
	 onPause 按钮失去焦点的时候；
	 onStop 界面不可见的时候调用；
     onDestroy 销毁activity实例，做一些释放资源工作。
简单测试：
	1、activity创建时调用onCreate、onStart、onResume；
	2、关闭activity时调用：onPause、onStop、onDestroy；
	3、最小化activity时调用：onPause、onStop；
	4、最小后重新打时调用：onRestart、onStart、onResume；
	 
```
##Activity横竖屏切换
**Activity横竖屏切换Activity的生命周期都会重新开始**

注：可以设置Activity横竖屏切换不敏感

```
在activity中或者清单文件中设置 android:configChanges="orientation|keyboardHidden|screenSize"
```
##Activity的启动模式

```
standard		默认 任务栈的方式 【先进后出】
singleTop		单一顶部模式，重复复用
singleTask		单一任务栈，当然任务栈只有一个实例存在，其他都被“杀死” 浏览器
singleInstance	自己的任务栈	来电界面

```
**关于作者**
	- Email：[xiaweifeng@live.cn](xiaweifeng@live.cn)
	- 项目地址:[https://github.com/swordman20/Hsia01ActivityDemo](https://github.com/swordman20/Hsia01ActivityDemo)







