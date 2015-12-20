package com.rifaz.simak;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
    EditText username, password;
    Button BTNlogin, Daftar, browse;
    CheckBox chck1;
    TextView txt1;
    String us;
    int get = 0;


    List<Model> list = new ArrayList<Model>();
    DBAdapter db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = new DBAdapter(getApplicationContext());
		
		username = (EditText)findViewById(R.id.usermane1);
		password = (EditText)findViewById(R.id.password1);
		BTNlogin = (Button)findViewById(R.id.BTNlogin);
		browse = (Button)findViewById(R.id.browse);
		Daftar = (Button)findViewById(R.id.daftar);
		chck1 = (CheckBox)findViewById(R.id.ingat);
		txt1 = (TextView)findViewById(R.id.textView1);
		
		browse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				get = get +1;
				list = db.autoGet(get);
				print(list);
			}
		});
		
		

        BTNlogin.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					Model mod = new Model();

					mod.username = username.getText().toString();
					mod.password = password.getText().toString();
					
					String us = mod.username;
					String pass = mod.password;
					db.getMHS(us,pass);
					
					Toast.makeText(getApplicationContext(),
                    "Login Berhasil", Toast.LENGTH_LONG).show();
				
					if(chck1.isChecked()){
						Model MHS = new Model();
						MHS.username = username.getText().toString();
						MHS.password = password.getText().toString();
					
						db.MHSingat(MHS);
					}
					
					String userN = username.getText().toString();
					
					Intent new_intent= new Intent("com.rifaz.simak.FormKRS");
					new_intent.putExtra("userN",userN);
					startActivity(new_intent);
					
				}catch(Exception ex){
	            	Toast.makeText(getApplicationContext(),
	                    "Login Gagal", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        Daftar.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.rifaz.simak.DaftarActivity"));
			}
		});	
    	Model mod = new Model();

    	mod.username = username.getText().toString();
    	mod.password = password.getText().toString();
	}
	
    private void print(List<Model> list) {
        // TODO Auto-generated method stub
		username = (EditText)findViewById(R.id.usermane1);
		password = (EditText)findViewById(R.id.password1);

		String value = "";
        for(Model sm : list){
            value = value+sm.username+sm.password;
        }
        username.setText(value);
    }
    

}
