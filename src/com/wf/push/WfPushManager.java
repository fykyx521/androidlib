package com.wf.push;

import android.content.Context;




public class WfPushManager {
	
	private static IWfPush push;
	public static void setPush(IWfPush push0)
	{
		push=push0;
	}
	
	public static void init()
	{
		push.init();
	}
	
	public static void start(Context ctx)
	{
		push.start(ctx);
	}
	
	public static void stop()
	{
		push.stop();
	}
	public static void debug(boolean enableDebug)
	{
		push.debug(enableDebug);
	}
}
