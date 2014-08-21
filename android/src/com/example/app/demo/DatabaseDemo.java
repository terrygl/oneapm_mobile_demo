package com.example.app.demo;


import util.Test;
import widget.CustomProgressDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.TextView;

public class DatabaseDemo extends Activity {
	private CustomProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_content_layout);

		TextView tvTitle = (TextView) findViewById(R.id.title);
		final TextView tvContent = (TextView) findViewById(R.id.content);
		tvTitle.setText(R.string.databaseTitle);
		progressDialog = CustomProgressDialog.createDialog(this);
		progressDialog.setMessage(R.string.processDialog);
		progressDialog.setCanceledOnTouchOutside(true);
		progressDialog.show();
		progressDialog.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				progressDialog.dismiss();
			}
		});
		new Thread(){
			public void run(){
				Test.testDatabase(DatabaseDemo.this);
				DatabaseDemo.this.runOnUiThread(new Runnable(){

					@Override
					public void run() {
						if (progressDialog != null && progressDialog.isShowing()) {
							progressDialog.dismiss();
						}
						tvContent.setText(R.string.databaseContent);
						
					}
					
				});
			};
		}.start();
		
		
	}
}
