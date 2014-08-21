package util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 
 * 作用：模拟网络加载图片之后对图片进行编码（decode）
 * 
 * 对应预览中的bitmap#decode
 * 
 * @author zxy
 *
 */
public class ImageFetchOp {

	public static void testImage(){
		NetWorkOperaction.tesNetwork();
	}
	
	 public static Bitmap getImage(String address) throws Exception{  
	        //通过代码 模拟器浏览器访问图片的流程   
	        URL url = new URL(address);  
	        HttpURLConnection conn =  (HttpURLConnection) url.openConnection();  
	        conn.setRequestMethod("GET");  
	        conn.setConnectTimeout(5000);  
	        //获取服务器返回回来的流   
	        InputStream is = conn.getInputStream();  
	        byte[] imagebytes = readBytes(is);  
	        Bitmap bitmap = BitmapFactory.decodeByteArray(imagebytes, 0, imagebytes.length);  
	        return bitmap;  
	    }  
	   
	   public static byte[] readBytes(InputStream in) throws IOException {  
	        BufferedInputStream bufin = new BufferedInputStream(in);  
	        int buffSize = 1024;  
	        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);  
	        
	        // System.out.println("Available bytes:" + in.available());  
	  
	        byte[] temp = new byte[buffSize];  
	        int size = 0;  
	        while ((size = bufin.read(temp)) != -1) {  
	            out.write(temp, 0, size);  
	        }  
	        bufin.close();  
	  
	        byte[] content = out.toByteArray();  
	        return content;  
	    } 
	 
}