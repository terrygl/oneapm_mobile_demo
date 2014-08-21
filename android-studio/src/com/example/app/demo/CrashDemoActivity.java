package com.example.app.demo;

 

import util.DbHelper;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 作用 ： 加载图片activity
 *
 */
public class CrashDemoActivity  extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.setContentView(R.layout.test_load_image);
		
		
		 
		/**
		 * 模拟数据越界的异常，写的比较长，是为了让看清楚调用的stack
		 * 
		 */
		DbHelper.testSql();
		
		
	}
}
