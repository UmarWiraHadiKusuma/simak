package com.rifaz.simak;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarActivity extends Activity implements OnClickListener{

    EditText nama, nim, email, username, password;
    Button BTNDaftar, HPSAkun;

    List<Model> list = new ArrayList<Model>();
    DBAdapter db;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);
        db = new DBAdapter(getApplicationContext());

        nama = (EditText)findViewById(R.id.nama);
        nim = (EditText)findViewById(R.id.nim);
        email = (EditText)findViewById(R.id.email);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        
        BTNDaftar = (Button) findViewById(R.id.BTNdaftar);
        HPSAkun = (Button) findViewById(R.id.delete);
        
        BTNDaftar.setOnClickListener(this);
        HPSAkun.setOnClickListener(this);

    }
    
    private void print(List<Model> list) {
        // TODO Auto-generated method stub
        String value = "";
        for(Model sm : list){
            value = value+"nama : "+sm.nama+", NIM : "+sm.nama+", email : "
            +sm.email+", username : "+sm.username+" password : "+sm.password+"\n";
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v == findViewById(R.id.delete)){
        	
        	try{
        		String NIMid = nim.getText().toString();
        		db.deleteEntry(Integer.parseInt(NIMid));
        		Toast.makeText(getApplicationContext(),
                    "Akun Anda Berhasil Di Hapus", Toast.LENGTH_LONG).show();
        		nim.setText("");
        	}
        	catch(Exception ex){
        		Toast.makeText(getApplicationContext(),
                        "Akun Tidak Terhapus ! Periksa Data Lengkap anda Kembali", Toast.LENGTH_LONG).show();
            	nama.setText("");
            	nim.setText("");
            	email.setText("");
            	username.setText("");
            	password.setText("");
        	}
        }
        
        if(v == findViewById(R.id.BTNdaftar)){

        	try{
        		Model MHS = new Model();
            
        		MHS.nama = nama.getText().toString();
        		MHS.nim = Integer.parseInt(nim.getText().toString());
        		MHS.email = email.getText().toString();
        		MHS.username = username.getText().toString();
            	MHS.password = password.getText().toString();
            
            	db.MHSdaftar(MHS);
            
            	Toast.makeText(getApplicationContext(),
                    "Anda Berhasil Daftar", Toast.LENGTH_LONG).show();
            	nama.setText("");
            	nim.setText("");
            	email.setText("");
            	username.setText("");
            	password.setText("");
            	finish();
            	
        }
    	catch(Exception ex){
    		Toast.makeText(getApplicationContext(),
                    "GAGAL Terdaftar! Periksa Data Lengkap anda Kembali", Toast.LENGTH_LONG).show();
        		nim.setText("");
    	}
            
        }
    }
}