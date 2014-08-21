package com.example.app.demo;

import widget.CustomProgressDialog;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * 
 * @author Aimee.zhang
 *
 */
public class ExplainActivity extends Activity {
	private String status = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		TextView TV_json = (TextView) findViewById(R.id.TV_json);
		TextView TV_content = (TextView) findViewById(R.id.TV_json_content);
		Button Test_btn = (Button) findViewById(R.id.Test_btn);
		Test_btn.setOnClickListener(testClick);
		Intent intent = getIntent();
		status=(String) intent.getSerializableExtra("status");
		switch (status) {
		case "json":
			TV_json.setText("测试json地址：http://tongdianer.com/out.json");
			TV_content.setText("测试取出weather1字段显示在页面中" + "\n" + "登陆：www.oneapm.com"
					+ "即可看到json解析过程性能监控");
			break;
		case "bitmap":
			TV_json.setText("测试图片地址：http://i.imgur.com/CdjPpmi.jpg");
			TV_content.setText("测试全程加载该图片显示在页面中" + "\n" + "登陆：www.oneapm.com"
					+ "即可看到解析图片性能监控");
			break;
		case "database":
			TV_json.setText("测试流程：网数据库中连续添加50个用户");
			TV_content.setText( "测试完毕，会在页面中显示：'插入了50个数据到数据库完毕'" + "\n"
					+ "登陆：www.oneapm.com" + "即可看到添加用户过程性能监控");
			break;
		case "viewloading":
			TV_json.setText("测试流程：在onCreate中加入一些下载网络上资源的代码，加大onCreate的执行时间");
			TV_content.setText( "加载一个大大的文件，这个会耗时很久" + "\n" + "登陆：www.oneapm.com"
					+ "即可看到页面加载过程性能监控");
			break;
		case "crash":
			TV_json.setText("测试流程：模拟产生一个异常,点击按钮异常退出该程序");
			TV_content.setText( "登陆：www.oneapm.com" + "即可看到捕获异常信息，造成异常的代码段等性能监控");
			break;
		default:
			break;
		}

	}

	OnClickListener testClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (status) {
			case "json":
				Intent intentJson = new Intent(ExplainActivity.this,
						LoadJsonActivity.class);
				ExplainActivity.this.startActivity(intentJson);
				break;
			case "bitmap":
				Intent intentImg = new Intent(ExplainActivity.this,
						LoadImgActivity.class);
				ExplainActivity.this.startActivity(intentImg);
				break;
			case "database":
				Intent intentDatabase = new Intent(ExplainActivity.this,
						DatabaseDemo.class);
				ExplainActivity.this.startActivity(intentDatabase);
				break;
			case "viewloading":
				Intent intentView = new Intent(ExplainActivity.this,
						ViewLoading.class);
				ExplainActivity.this.startActivity(intentView);
				break;
			case "crash":
				Intent intentCrash = new Intent(ExplainActivity.this,
						CrashDemoActivity.class);
				ExplainActivity.this.startActivity(intentCrash);
				break;
			default:
				break;
			}
		}
	};
}
