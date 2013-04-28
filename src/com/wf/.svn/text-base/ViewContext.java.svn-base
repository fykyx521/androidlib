package com.wf;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

//注释处理类
public class ViewContext<T> {

	private String TAG="com.careland.ViewUtil";
	private static ThreadLocal<ViewContext> context=new ThreadLocal<ViewContext>();
	
	private  T acitivity;
	private Map<String,Object> fields;//acitvity 中 所有属性
	
	public ViewContext(T acitivity)
	{
		this.acitivity=acitivity;
		fields=new HashMap<String,Object>();
	}
	//获取当前的Activity 
	public T getCurrentActivity()
	{
		return acitivity;
	}
	//保存 和获取 当前Activity的成员变量
	public Map<String,Object> getFields()
	{
		return fields;
	}
	public Object get(String key)
	{
		return fields.get(key);
	}
	public void put(String key,Object value)
	{
		fields.put(key, value);
	}
	
	public static boolean notNullOrEmpty(String value)
	{
		return value!=null&&(!"".equals(value.trim()));
	}
	
	public static ViewContext getContext()
	{
		return context.get();
	}
	public static void setContext(ViewContext ctx)
	{
	      context.set(ctx);
	}
	//解析注释   注入成员变量实例 绑定事件
	protected void HandlerAnnotation(Field field,ViewAdapter ctx)
	{
		
		FindView fv=field.getAnnotation(FindView.class);
		if(fv!=null)
		 {
			 int viewId=fv.id();
			 String className=fv.className();
			
			 try {
				field.setAccessible(true);
				View viewobj=ctx.findViewById(viewId);
				field.set(ctx, ctx.findViewById(viewId));
				this.put(field.getName(),viewobj);//
				String touch=fv.touch();
				String click=fv.click();
				String longclick=fv.longclick();
				String itemclick=fv.itemclick();
				if(viewobj instanceof View)
				{
					View view=(View) viewobj;
					if(notNullOrEmpty(touch))
					{
						view.setOnTouchListener(new ViewEventHandler(ctx,touch,className));
					}
					if(notNullOrEmpty(click))
					{
						view.setOnClickListener(new ViewEventHandler(ctx,click,className));
					}
					if(notNullOrEmpty(longclick))
					{
						view.setOnLongClickListener(new ViewEventHandler(ctx,click,className));
					}
					if(notNullOrEmpty(itemclick))
					{
						if(view instanceof AdapterView)
						{
							((AdapterView)view).setOnItemClickListener(new ViewEventHandler(ctx,click,className));
						}
					}
					
//					OnItemClickListener f = (OnItemClickListener) Proxy.newProxyInstance(OnItemClickListener.class.getClassLoader(),
//                            new Class[] { OnItemClickListener.class },
//                            handler);
					
					
				}
				
			 } catch (Exception e) {
				Log.d(TAG, "自动初始化View失败",e);
			 }
			 
		 }
	}
	
	class ViewAdapter<A>
	{
		private A viewAdapter;
		public View findViewById(int id)
		{
			if(viewAdapter instanceof View)
			{
				return ((View)viewAdapter).findViewById(id);
			}
			return ((Activity) viewAdapter).findViewById(id);
		}
	}
	
	public void GetElement(Object ctx)
	{
		 Field[] fields=ctx.getClass().getDeclaredFields();
		 for(Field field:fields)
		 {  
			 this.HandlerAnnotation(field, new ViewAdapter<Object>());
		 }
	}
}
