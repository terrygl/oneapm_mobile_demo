package com.example.app.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.blueware.agent.android.BlueWare;
/**
 * 
 * @author Aimee.zhang
 *
 */
public class MainActivity extends Activity {
private LinearLayout LL_error1,LL_error2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 BlueWare.withApplicationToken("917700F1DF01D658D62A50ED436D16FC23")
		 .start(this.getApplication());
		 DisplayMetrics dm=new DisplayMetrics();
		 dm=getResources().getDisplayMetrics();
		 LL_error1=(LinearLayout) findViewById(R.id.LL_error1);
		 LL_error2=(LinearLayout) findViewById(R.id.LL_error2);
		 int screenWidth=dm.widthPixels;
		 LL_error1.getLayoutParams().height=screenWidth/3;
		 LL_error2.getLayoutParams().height=screenWidth/3;
		 
		// crash是从这里开始测试，手机联网状态会实时上传，在后台可见，如果传输失败，会在下次APP启动的时候上传
		findViewById(R.id.crash_demo).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ExplainActivity.class);
				intent.putExtra("status", "crash");
				MainActivity.this.startActivity(intent);
			}
		});
		findViewById(R.id.crash_demo).setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						CrashDemoActivity.class);
				MainActivity.this.startActivity(intent);
				return true;
			}
		});

		// json 解析，这里的测试在后台交互中可以看见预览，在交互详情可以看见详细的数据。
		findViewById(R.id.json_demo).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ExplainActivity.class);
				intent.putExtra("status", "json");
				MainActivity.this.startActivity(intent);
			}
		});
		findViewById(R.id.json_demo).setOnLongClickListener(
				new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								LoadJsonActivity.class);
						MainActivity.this.startActivity(intent);
						return true;
					}
				});

		// 图片解析 解析，这里的测试在后台交互中可以看见预览，在交互详情可以看见详细的数据。
		findViewById(R.id.bitmap_decode_demo).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MainActivity.this,
								ExplainActivity.class);
						intent.putExtra("status", "bitmap");
						MainActivity.this.startActivity(intent);
					}
				});
		findViewById(R.id.bitmap_decode_demo).setOnLongClickListener(
				new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								LoadImgActivity.class);
						MainActivity.this.startActivity(intent);
						return true;
					}
				});
		//
		// 数据库访问，这里的测试在后台交互中可以看见预览，在交互详情可以看见详细的数据。
		findViewById(R.id.database_demo).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MainActivity.this,
								ExplainActivity.class);
						intent.putExtra("status", "database");
						MainActivity.this.startActivity(intent);
					}
				});
		findViewById(R.id.database_demo).setOnLongClickListener(
				new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								DatabaseDemo.class);
						MainActivity.this.startActivity(intent);
						return true;
					}
				});

		// 数据库访问，这里的测试在后台交互中可以看见预览，在交互详情可以看见详细的数据。
		findViewById(R.id.viewloading_demo).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MainActivity.this,
								ExplainActivity.class);
						intent.putExtra("status", "viewloading");
						MainActivity.this.startActivity(intent);
					}
				});
		findViewById(R.id.viewloading_demo).setOnLongClickListener(
				new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								ViewLoading.class);
						MainActivity.this.startActivity(intent);
						return true;
					}
				});

	}

}
