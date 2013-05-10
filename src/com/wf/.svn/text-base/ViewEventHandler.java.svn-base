package com.wf;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

//�Ը����¼��Ĵ���
public class ViewEventHandler implements OnClickListener, 
OnTouchListener,OnItemClickListener,
OnLongClickListener {

	private String TAG="com.wf.ViewHandler";
	private Object handler; //��ǰʵ��  Ĭ��activity 
	private String methodName; //Ҫִ�е�Ŀ�귽�� 
	private String handlerClass;//Ҫִ�е�Ŀ���� 
	public ViewEventHandler(Object handler, String method,String handlerClass) {
		this.handler=handler;
		this.methodName=method;
		this.handlerClass=handlerClass;
	}
	
	public ViewEventHandler(Object handler, String method) {
		this(handler,method,"");
	}
	/***
	 * touch �����¼�
	 * */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		ReflectMethod method=new ReflectMethod(View.class,MotionEvent.class);
		return (Boolean) method.invoke(v,event);
	}
	/**
	 *  click�����¼�
	 * **/
	@Override
	public void onClick(View v) {
		ReflectMethod method=new ReflectMethod(View.class);
	    method.invoke(v);
	}
	/**
	 * ִ��itemClick�¼�
	 * */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ReflectMethod method=new ReflectMethod(AdapterView.class,View.class,Integer.class,Long.class);
		method.invoke(parent,view,position,id);
		
	}
	/**
	 * ִ��Longclick�¼�
	 * */
	@Override
	public boolean onLongClick(View v) {
		ReflectMethod method=new ReflectMethod(View.class);
		return (Boolean) method.invoke(v);
	}
	
	//����Ŀ�귽����
	class ReflectMethod
	{
		public Object instance;
		public Method method=null;
		
		public ReflectMethod(Class... params)
		{
			if(!"".equals(handlerClass))
			{
				this.init(handlerClass, methodName, params);
			}else
			{
				this.init(handler, methodName, params);
			}
		}
		
		public ReflectMethod(Object instance,Method method)
		{
			this.instance=instance;
			this.method=method;
			
		}
		public Object invoke(Object... params) 
		{
			try {
				return method.invoke(instance, params);
			} catch (Exception e) {
				Log.e(TAG, ""+method.getName()+" error",e);
			}
			return null;
		}
		public void init(String className,String methodName,Class... params)
		{
			try {
				Class cls = Class.forName(className);
				this.instance=cls.newInstance();
				this.init(instance,methodName,params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void init(Object instance,String methodName,Class... params)
		{
			try {
				this.instance=instance;
				this.method=instance.getClass().getDeclaredMethod(methodName,params);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

	
	
	

	

}
