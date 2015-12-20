package com.rifaz.simak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class FormKRS extends Activity {
	
	Button btn2;
	CheckBox chck1, chck2, chck3, chck4, chck5, chck6, chck7;
	String a,b,c,d,e,f,g;
	
	@Override
	public void onBackPressed(){
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formkrs);
		
		btn2 = (Button)findViewById(R.id.BTNsimpan);
		chck1 = (CheckBox)findViewById(R.id.checkBox1);
		chck2 = (CheckBox)findViewById(R.id.checkBox2);
		chck3 = (CheckBox)findViewById(R.id.checkBox3);
		chck4 = (CheckBox)findViewById(R.id.checkBox4);
		chck5 = (CheckBox)findViewById(R.id.checkBox5);
		chck6 = (CheckBox)findViewById(R.id.checkBox6);
		chck7 = (CheckBox)findViewById(R.id.checkBox7);
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(chck1.isChecked()){
					a = chck1.getText().toString();
				}else{
					a = "";
				}
				
				
				if(chck2.isChecked()){
					b = chck2.getText().toString();
				}else{
					b = "";
				}
				
				if(chck3.isChecked()){
					c = chck3.getText().toString();
				}else{
					c = "";
				}
				
				if(chck4.isChecked()){
					d = chck4.getText().toString();
				}else{
					d = "";
				}
				
				if(chck5.isChecked()){
					e = chck5.getText().toString();
				}else{
					e = "";
				}
				
				if(chck6.isChecked()){
					f = chck6.getText().toString();
				}else{
					f = "";
				}
				
				if(chck7.isChecked()){
					g = chck7.getText().toString();
				}else{
					g = "";
				}
				
				Bundle bundle = getIntent().getExtras();
				String userN = bundle.getString("userN");
						
				Intent new_intent= new Intent("com.rifaz.simak.Hasil");
				new_intent.putExtra("userN",userN);
				new_intent.putExtra("a",a);
				new_intent.putExtra("b",b);
				new_intent.putExtra("c",c);
				new_intent.putExtra("d",d);
				new_intent.putExtra("e",e);
				new_intent.putExtra("f",f);
				new_intent.putExtra("g",g);
				startActivity(new_intent);
				
			}
		});
		
	}
	
}
