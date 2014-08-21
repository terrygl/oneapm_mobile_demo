package util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class Test {

	private static final String TAG = "Test";
	
	public static void testDatabase(Context context) {
		// 数据库操作
		DbHelper dbhelper = new DbHelper(context);
		for (int i = 0; i < 50; i++) {
			User user = new User();
			user.setName("user" + i);
			user.setPwd("user" + i);
			dbhelper.addUser(user);
		}
	}
	
	public static void parseJson() {
		// 网络操作
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String ret = "";
					try {
						ret = NetWorkOperaction
								.requestByHttpGet("http://tongdianer.com/out.json");
						NetWorkOperaction.WeatherModel m = NetWorkOperaction.WeatherModel
								.parse(ret);
						Log.d(TAG, m.toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 模拟产生一个异常
	 * 
	 */
	public   static void  createCrash(){
		int [] a  = {8,9,6,5};
		int b = a[90];
	}
	
	
}
