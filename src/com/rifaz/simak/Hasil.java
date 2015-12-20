package com.rifaz.simak;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Hasil extends Activity {
	List<Model> list = new ArrayList<Model>();
	DBAdapter db;
	TextView txt1, txt2, txt3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hasil);
		db = new DBAdapter(getApplicationContext());
		String userN;
		
		txt2 = (TextView)findViewById(R.id.textView2);
		txt3 = (TextView)findViewById(R.id.textView3);
		
		Bundle bundle = getIntent().getExtras();
		userN = bundle.getString("userN");
		String a = bundle.getString("a");
		String b = bundle.getString("b");
		String c = bundle.getString("c");
		String d = bundle.getString("d");
		String e = bundle.getString("e");
		String f = bundle.getString("f");
		String g = bundle.getString("g");
		
		list = db.getAllMenuList(userN);
		print(list);
		
		txt3.setText(a + "\n" + b + "\n" + c + "\n" + d 
				+ "\n" + e + "\n" + f + "\n" + g);
	}
	
	private void print(List<Model> list) {
        // TODO Auto-generated method stub
		String value = "";
		for(Model sm : list){
			value = value+"Nama : " + sm.nama+ "\n" 
          			+"Email	: " + sm.email;
 	       }
		txt2.setText(value);
	  }
	
}
