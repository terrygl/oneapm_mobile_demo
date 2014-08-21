package com.example.app.demo;

import util.NetWorkOperaction;
import widget.CustomProgressDialog;
import android.os.StrictMode;
import android.widget.TextView;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 
 * @author Aimee.zhang
 *
 */
public class ViewLoading extends Activity {
	private CustomProgressDialog progressDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_content_layout);
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
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		TextView tvTitle = (TextView) findViewById(R.id.title);
		final TextView tvContent = (TextView) findViewById(R.id.content);
		tvTitle.setText(R.string.title_ViewLoading);

		/**
		 * 
		 * ViewLoading
		 * 即页面加载时间，统计页面加载时间对于应用开发者来说很有意义，试想如果一个页面加载了1分钟还是黑屏，用户还会等吗？用户离开意味着
		 * 对于开发者来说，这个APP 就是没用！
		 * 
		 * 在Android中页面加载的周期是从onCreate 到 onResume的这个过程，
		 * 
		 * 我们在onCreate中加入一些下载网络上资源的代码，加大onCreate的执行时间，来测试。
		 * 
		 * 
		 * 你去给我加载一个大大的文件吧 ！这个会耗时很久
		 * 
		 * 这个图片：http://i.imgur.com/CdjPpmi.jpg ，大小300多K，加载3次大概是1M的流量
		 * 
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					String url = "http://i.imgur.com/CdjPpmi.jpg";

					NetWorkOperaction.requestByHttpGet(url);
					NetWorkOperaction.requestByHttpGet(url);
					NetWorkOperaction.requestByHttpGet(url);

					ViewLoading.this.runOnUiThread(new Runnable() {

						@Override
						public void run() {
							if (progressDialog != null
									&& progressDialog.isShowing()) {
								progressDialog.dismiss();
							}
							tvContent
									.setText(R.string.content_ViewLoading);

						}

					});

				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(ViewLoading.this,R.string.ToastViewLoading, 1).show();
					e.printStackTrace();
				}

			}
		}).start();
	}
}
