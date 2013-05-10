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


public class ViewContext<T> {

	private String TAG="com.careland.ViewUtil";
	private static ThreadLocal<ViewContext> context=new ThreadLocal<ViewContext>();
	
	private  T acitivity;
	private Map<String,Object> fields;//acitvity �� ��������
	
	public ViewContext(T acitivity)
	{
		this.acitivity=acitivity;
		fields=new HashMap<String,Object>();
	}
	//��ȡ��ǰ��Activity 
	public T getCurrentActivity()
	{
		return acitivity;
	}
	//���� �ͻ�ȡ ��ǰActivity�ĳ�Ա����
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
	//处理注释
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
				field.set(ctx.getInstance(), viewobj);
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
						view.setOnTouchListener(new ViewEventHandler(ctx.getInstance(),touch,className));
					}
					if(notNullOrEmpty(click))
					{
						view.setOnClickListener(new ViewEventHandler(ctx.getInstance(),click,className));
					}
					if(notNullOrEmpty(longclick))
					{
						view.setOnLongClickListener(new ViewEventHandler(ctx.getInstance(),longclick,className));
					}
					if(notNullOrEmpty(itemclick))
					{
						if(view instanceof AdapterView)
						{
							((AdapterView)view).setOnItemClickListener(new ViewEventHandler(ctx.getInstance(),itemclick,className));
						}
					}
					
//					OnItemClickListener f = (OnItemClickListener) Proxy.newProxyInstance(OnItemClickListener.class.getClassLoader(),
//                            new Class[] { OnItemClickListener.class },
//                            handler);
					
					
				}
				
			 } catch (Exception e) {
				Log.d(TAG, "",e);
			 }
			 
		 }
	}
	
	class ViewAdapter<A>
	{
		
		private A viewAdapter;
		public ViewAdapter(A viewAdapter)
		{
			this.viewAdapter=viewAdapter;
		}
		public View findViewById(int id)
		{
			if(viewAdapter instanceof View)
			{
				return ((View)viewAdapter).findViewById(id);
			}
			return ((Activity) viewAdapter).findViewById(id);
		}
		public A getInstance()
		{
			return viewAdapter;
		}
	}
	
	public void GetElement(Object ctx)
	{
		 Field[] fields=ctx.getClass().getDeclaredFields();
		 for(Field field:fields)
		 {  
			 this.HandlerAnnotation(field, new ViewAdapter<Object>(ctx));
		 }
	}
}
