package com.wf.test;



import java.lang.reflect.Method;

import com.wf.ViewContext;
import com.wf.test.TestActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestHandler{
	
	
	
	
	public void btn2Click(View view)
	{
		//获取btn1 
		Button btn1=(Button) ViewContext.getContext().get("btn1");
		Log.d("test", btn1.getText().toString());//获取btn1 的text
		
		
		//获取当前activity
		TestActivity act=(TestActivity) ViewContext.getContext().getCurrentActivity();
		act.doAction();
		
		((Button)view).setText("click2");
		Log.d("careland", "btn2 click");
	}
}
