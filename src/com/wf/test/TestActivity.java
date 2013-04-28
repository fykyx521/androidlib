package com.wf.test;

import com.wf.FindView;
import com.wf.R;
import com.wf.WfAndroidLibActivity;
import com.wf.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TestActivity extends WfAndroidLibActivity {
	
	 
	 @FindView(click="btn1Click", id = R.id.btn1) //标注ID,绑定当前TestActivity的btn1Click方法
	 private Button btn1;
	 
	 //绑定 TestHandler中的 btn2Click方法
	 @FindView(click="btn2Click",className="com.wf.test.TestHandler", id = R.id.btn2)
	 private Button btn2;
	 
	 public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      this.setContentView(R.layout.main);
	      Window win=this.getWindow();
		  win.getDecorView();
	      btn1.setText("btn1  click"); //测试直接赋值
	      btn2.setText("btn2  click");
	      
	 }
	 public void doAction()
	 {
		 Log.d("test", "TestHandler call");
	 }
	      
	 public void btn1Click(View view){
		 ((Button)view).setText("click1");
		 Log.d("careland", "btn1---------click");
		 
	 }
}
