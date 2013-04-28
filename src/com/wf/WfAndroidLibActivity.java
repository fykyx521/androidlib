package com.wf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
//Activity 基类  注入基类 绑定事件
public class WfAndroidLibActivity extends Activity {
    /** Called when the activity is first created. */
	private String TAG="com.careland.WfAndroidLibActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override 
    public View onCreateView(String name,Context context,AttributeSet attrs)
    {
    	
    	try {
			View view=this.getLayoutInflater().createView(name, "android.view.", attrs);
			return view;
		} catch (Exception e) {
			
		}
		return null;
    	
    }
    @Override 
    public void setContentView(View view)
    {
    	super.setContentView(view);
    	GetElement();
    }
    @Override 
    public void setContentView(int id)
    {
    	super.setContentView(id);
    	GetElement();
    }
    @Override 
    public void setContentView(View view,LayoutParams param)
    {
    	super.setContentView(view, param);
    	GetElement();
    }
    /**
     * 注入属性实例 绑定事件
     * **/
    protected void GetElement()
    {
    	 ViewContext<WfAndroidLibActivity> viewContext=new ViewContext<WfAndroidLibActivity>(this);
    	 ViewContext.setContext(viewContext);
    	 viewContext.GetElement(this);
    }
}