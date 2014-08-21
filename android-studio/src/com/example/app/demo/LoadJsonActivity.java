package com.example.app.demo;

 
import util.NetWorkOperaction;
import android.os.StrictMode;
import android.app.Activity;
import android.content.res.Resources;
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
		 
		 
		 tvTitle.setText(R.string.title_Loadjson);		 
		 
		 
		 try {
				String  ret = NetWorkOperaction.requestByHttpGet("http://tongdianer.com/out.json");
				NetWorkOperaction.WeatherModel m = NetWorkOperaction.WeatherModel.parse(ret);
				String content=getResources().getString(R.string.content_Loadjson);
				tvContent.setText(content+m.weather1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, R.string.ToastLoadjson, 1).show();
				e.printStackTrace();
			}
	}

}
