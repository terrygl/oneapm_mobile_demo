package com.example.app.demo;

 
import test.NetWorkOperaction;
import android.os.StrictMode;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoadJsonActivity  extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

		setContentView(R.layout.show_content_layout);
		
		 TextView tvTitle = (TextView) findViewById(R.id.title);
		 TextView tvContent = (TextView) findViewById(R.id.content);
		 
		 
		 tvTitle.setText("测试json加载,这个是一个天气预报的数据，请求的json数据显示在下面");		 
		 
		 
		 try {
				String  ret = NetWorkOperaction.requestByHttpGet("http://tongdianer.com/out.json");
				NetWorkOperaction.WeatherModel m = NetWorkOperaction.WeatherModel.parse(ret);
				tvContent.setText("天气："+m.weather1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "接口访问失败，请登录OneAPM追本溯源", 1).show();
				e.printStackTrace();
			}
	}

}
