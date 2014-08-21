package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class utils {

	  public static String  collectLogs(Context context,String logFilter)
	  {
	    StringBuilder localStringBuilder = new StringBuilder();
	    try
	    {
	      Process localProcess = Runtime.getRuntime().exec(new StringBuilder().append(" logcat -d   "+context.getPackageName()+"  ").append(logFilter).toString());
	      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
	      @SuppressWarnings("rawtypes")
		  ArrayList localArrayList = new ArrayList();
	      String line;
	      while ((line = localBufferedReader.readLine()) != null){
              localStringBuilder.append(line+"\n");
          }
	      return localStringBuilder.toString();
	    }
	    catch (Exception localException)
	    {
	      Log.e("", "Error reading logcat output!");
	    }
         return  String.valueOf("");
	  }

	  
	  
	  public static void utilsTest(){
		  Test.createCrash();
	  }
}
