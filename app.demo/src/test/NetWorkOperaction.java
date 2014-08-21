package test;

import java.net.HttpURLConnection;
import java.net.URL;

 
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.blueware.com.google.gson.JsonArray;

import android.graphics.PorterDuff.Mode;
import android.util.Log;

/**
 * 作用测试网络请求和数据解析
 * 
 * 对应预览中的network和json
 * 
 * @author zxy
 *
 */
public class NetWorkOperaction {
	private final static String TAG = "TAG";


	public static void tesNetwork(){
		utils.utilsTest();
	}
	
	public static String  requestByHttpGet(String url) throws Exception {
	    String  ret = null;
	    HttpGet httpGet = new HttpGet(url);
	    AbstractHttpClient httpClient = new DefaultHttpClient();
	    HttpResponse httpResp = httpClient.execute(httpGet);
	    if (httpResp.getStatusLine().getStatusCode() == 200) {
	    	ret = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
	        Log.i(TAG, "HttpGet方式请求成功，返回数据如下：");
	        Log.i(TAG, ret);
	    } else {
	        Log.i(TAG, "HttpGet方式请求失败");
	    }

	    return ret;
	}

	/**
	 *
	 *  {   "data":[
	{"code":1},
	{"msg":"query suc"},
     ],
    "weatherinfo": {
        "city": "北京",
        "city_en": "beijing",
        "date_y": "2014年3月4日",
        "date": "",
        "week": "星期二",
        "fchh": "11",
        "cityid": "101010100",
        "temp1": "8℃~-3℃",
        "temp2": "8℃~-3℃",
        "temp3": "7℃~-3℃",
        "temp4": "8℃~-1℃",
        "temp5": "10℃~1℃",
        "temp6": "10℃~2℃",
        "tempF1": "46.4℉~26.6℉",
        "tempF2": "46.4℉~26.6℉",
        "tempF3": "44.6℉~26.6℉",
        "tempF4": "46.4℉~30.2℉",
        "tempF5": "50℉~33.8℉",
        "tempF6": "50℉~35.6℉",
        "weather1": "晴",
        "weather2": "晴",
        "weather3": "晴",
        "weather4": "晴转多云",
        "weather5": "多云",
        "weather6": "多云",
        "img1": "0",
        "img2": "99",
        "img3": "0",
        "img4": "99",
        "img5": "0",
        "img6": "99",
        "img7": "0",
        "img8": "1",
        "img9": "1",
        "img10": "99",
        "img11": "1",
        "img12": "99",
        "img_single": "0",
        "img_title1": "晴",
        "img_title2": "晴",
        "img_title3": "晴",
        "img_title4": "晴",
        "img_title5": "晴",
        "img_title6": "晴",
        "img_title7": "晴",
        "img_title8": "多云",
        "img_title9": "多云",
        "img_title10": "多云",
        "img_title11": "多云",
        "img_title12": "多云",
        "img_title_single": "晴",
        "wind1": "北风4-5级转微风",
        "wind2": "微风",
        "wind3": "微风",
        "wind4": "微风",
        "wind5": "微风",
        "wind6": "微风",
        "fx1": "北风",
        "fx2": "微风",
        "fl1": "4-5级转小于3级",
        "fl2": "小于3级",
        "fl3": "小于3级",
        "fl4": "小于3级",
        "fl5": "小于3级",
        "fl6": "小于3级",
        "index": "寒冷",
        "index_d": "天气寒冷，建议着厚羽绒服、毛皮大衣加厚毛衣等隆冬服装。年老体弱者尤其要注意保暖防冻。",
        "index48": "冷",
        "index48_d": "天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。",
        "index_uv": "中等",
        "index48_uv": "中等",
        "index_xc": "较适宜",
        "index_tr": "一般",
        "index_co": "较舒适",
        "st1": "7",
        "st2": "-3",
        "st3": "8",
        "st4": "0",
        "st5": "7",
        "st6": "-1",
        "index_cl": "较不宜",
        "index_ls": "基本适宜",
        "index_ag": "易发"
    }
}
	 * @author andy
	 *
	 */
	public static class  WeatherModel {

		//TODO 解析更多
		public  String code;
		public  String  msg;
		public  String  city ;
		public  String date_y;
		public  String temp1;
		public  String weather1;


		public static WeatherModel parse(String str) throws JSONException{
			WeatherModel model = new WeatherModel();
			JSONObject obj = new JSONObject(str);
			JSONArray  data = obj.optJSONArray("data");
			//data
			if(data!=null){
				JSONObject codeObj = (JSONObject) data.get(0);
				model.code =  (codeObj.optString("code")==null)? "":codeObj.optString("code");

				JSONObject msgObj = (JSONObject) data.get(1);
				model.msg =  (msgObj.optString("msg")==null)? "":msgObj.optString("msg");
			}
			//weather
			JSONObject weatherinfo = obj.optJSONObject("weatherinfo");
			if(weatherinfo!=null){
				model.city = (weatherinfo.optString("city")==null)? "":weatherinfo.optString("city");
				model.temp1 = (weatherinfo.optString("temp1")==null)? "":weatherinfo.optString("temp1");
				model.weather1 = (weatherinfo.optString("weather1")==null)? "":weatherinfo.optString("weather1");
				model.date_y = (weatherinfo.optString("date_y")==null)? "":weatherinfo.optString("date_y");
			}
			return model;
		}

		@Override
		public String toString() {
		    return "query code="+code+",city:"+city+",weather1:"+weather1;
		}

	}



}
