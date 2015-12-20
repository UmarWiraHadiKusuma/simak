package com.rifaz.simak;

import android.annotation.SuppressLint;
import android.app.Activity;


@SuppressLint("DefaultLocale")
public class passEnkripsi extends Activity {
	
	private String arrays[];
	private String array2[] = new String[200];
	private String c;
	private String d;
	StringBuilder k = new StringBuilder();
	int i,s,t,f,r;
	
	@SuppressLint("DefaultLocale")
	public void enkripsi(){
		//c = String.valueOf(ed2.getText()).toUpperCase();
		//d = String.valueOf(ed1.getText());
		
		
		for(i=0; i<arrays.length; i++){
			if(arrays[i].equals(c)){

				for(s=0; s<d.length(); s++){
					array2[s] = String.valueOf(d.substring(s, s+1));	
				}
				
				for(t=0; t < d.length(); t++){
					for(f=0; f < arrays.length; f++){
						if(arrays[f].equals(array2[t].toUpperCase())){
							int l=f+i;
							if(l>25){
								l=l-26;
							}
							k.append(String.valueOf(arrays[l]));
						}
					}
				}		
			}
		}
		//ed3.setText(k);
	}
	
	@SuppressLint("DefaultLocale")
	public void dekripsi(){
		//c = String.valueOf(ed2.getText()).toUpperCase();
		//d = String.valueOf(ed1.getText());
		
		
		for(i=0; i<arrays.length; i++){
			if(arrays[i].equals(c)){

				for(s=0; s<d.length(); s++){
					array2[s] = String.valueOf(d.substring(s, s+1));	
				}
				
				for(t=0; t < d.length(); t++){
					for(f=0; f < arrays.length; f++){
						if(arrays[f].equals(array2[t].toUpperCase())){
							int l=f-i;
							if(l<0){
								l=l+26;
							}
							
							k.append(String.valueOf(arrays[l]));
						}
					}
				}		
			}
		}
		//ed3.setText(k);	
	}
}