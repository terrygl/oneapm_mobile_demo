package com.example.app.demo;

 

import test.ImageFetchOp;
import widget.CustomProgressDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 作用 ： 加载图片activity
 * @author Aimee.zhang
 *
 */
public class LoadImgActivity  extends Activity{
	private CustomProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.test_load_image);
		progressDialog = CustomProgressDialog.createDialog(this);
		progressDialog.setMessage("正在加载...");
		progressDialog.setCanceledOnTouchOutside(true);
		progressDialog.show();
		progressDialog.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface arg0) {
				progressDialog.dismiss();
			}
		});
		//测试加载一个远程的图片，并decode 
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				final ImageView img = (ImageView) findViewById(R.id.iamgeView);
				try {
					final Bitmap bitmap =  ImageFetchOp.getImage("http://i.imgur.com/CdjPpmi.jpg");
					if(bitmap!=null){
						LoadImgActivity.this.runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								if (progressDialog != null && progressDialog.isShowing()) {
									progressDialog.dismiss();
								}
								img.setImageBitmap(bitmap);		
							}
						});
					}
							
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(LoadImgActivity.this, "网络图片访问失败，请登录OneAPM追本溯源", 1).show();
					e.printStackTrace();
				}
			}
		}).start();
		
		
	}
}
