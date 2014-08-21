package com.example.app.demo;

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
		status = (String) intent.getSerializableExtra("status");
		if (status.equals("json")) {
			TV_json.setText(R.string.ExplainJson);
			TV_content.setText(R.string.ExplainJsonContent);
		} else if (status.equals("bitmap")) {
			TV_json.setText(R.string.ExplainBitmap);
			TV_content.setText(R.string.ExplainBitmapContent);
		} else if (status.equals("database")) {
			TV_json.setText(R.string.ExplainDatabase);
			TV_content.setText(R.string.ExplainBitmapContent);
		} else if (status.equals("viewloading")) {
			TV_json.setText(R.string.ExplainViewloading);
			TV_content.setText(R.string.ExplainViewloadingContent);
		} else if (status.equals("crash")) {
			TV_json.setText(R.string.ExplainCrash);
			TV_content.setText(R.string.ExplainCrashContent);
		}

	}

	OnClickListener testClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (status.equals("json")) {
				Intent intentJson = new Intent(ExplainActivity.this,
						LoadJsonActivity.class);
				ExplainActivity.this.startActivity(intentJson);
			} else if (status.equals("bitmap")) {
				Intent intentImg = new Intent(ExplainActivity.this,
						LoadImgActivity.class);
				ExplainActivity.this.startActivity(intentImg);
			} else if (status.equals("database")) {
				Intent intentDatabase = new Intent(ExplainActivity.this,
						DatabaseDemo.class);
				ExplainActivity.this.startActivity(intentDatabase);
			} else if (status.equals("viewloading")) {
				Intent intentView = new Intent(ExplainActivity.this,
						ViewLoading.class);
				ExplainActivity.this.startActivity(intentView);
			} else if (status.equals("crash")) {
				Intent intentCrash = new Intent(ExplainActivity.this,
						CrashDemoActivity.class);
				ExplainActivity.this.startActivity(intentCrash);
			}
		}
	};
}
